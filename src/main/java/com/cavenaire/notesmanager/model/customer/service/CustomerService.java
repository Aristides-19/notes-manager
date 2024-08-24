package com.cavenaire.notesmanager.model.customer.service;

import com.cavenaire.notesmanager.model.EntityService;
import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.customer.repository.CustomerRepository;
import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.model.invoicerecord.service.InvoiceService;

import static com.cavenaire.notesmanager.model.ServiceLayerException.*;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Service Layer for {@code customers}.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements EntityService<Customer> {

    private final CustomerRepository customerRepository;
    @Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
    private InvoiceService invoiceService;

    @Override
    public Customer save(@NonNull Customer customer) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.save(customer));
    }

    @Override
    public void delete(@NonNull Customer customer) throws ServiceLayerException {
        exceptionHandler(() -> customerRepository.delete(customer));
    }

    @Override
    public void update(@NonNull Customer customer) throws ServiceLayerException {
        exceptionHandler(() -> customerRepository.update(customer));
    }

    @Transactional(readOnly = true)
    public int getCount() throws ServiceLayerException {
        return exceptionHandler(customerRepository::getCount);
    }

    @Transactional(readOnly = true)
    public Map<String, Integer> getCountByType() throws ServiceLayerException {
        return exceptionHandler(customerRepository::getCountByType);
    }

    @Transactional(readOnly = true)
    public Customer getByLastTimestamp() throws ServiceLayerException {
        return exceptionHandler(customerRepository::getByLastTimestamp);
    }

    @Transactional(readOnly = true)
    public Customer getById(Long id) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.getById(id));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByName(String query) throws ServiceLayerException {
        return exceptionHandler(() -> findCustomersInvoices(customerRepository.findAllByName(query)));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByDoc(String query) throws ServiceLayerException {
        return exceptionHandler(() -> findCustomersInvoices(customerRepository.findAllByDoc(query)));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll(int limit) throws ServiceLayerException {
        return exceptionHandler(() -> findCustomersInvoices(customerRepository.findAll(limit)));
    }

    private List<Customer> findCustomersInvoices(List<Customer> customers) {
        customers.forEach(customer -> {
            customer.setInvoiceRecords(invoiceService.findAllByCustomerId(customer.getCustomerId()));
            customer.getInvoiceRecords().forEach(invoice -> invoice.setCustomer(customer));
        });
        return customers;
    }
}
