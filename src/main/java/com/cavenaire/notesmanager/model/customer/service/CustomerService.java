package com.cavenaire.notesmanager.model.customer.service;

import com.cavenaire.notesmanager.model.EntityService;
import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.customer.repository.CustomerRepository;
import com.cavenaire.notesmanager.model.ServiceLayerException;

import static com.cavenaire.notesmanager.model.ServiceLayerException.*;

import lombok.RequiredArgsConstructor;
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

    @Override
    public Customer save(Customer customer) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.save(customer));
    }

    @Override
    public void delete(Customer customer) throws ServiceLayerException {
        exceptionHandler(() -> customerRepository.delete(customer));
    }

    @Override
    public void update(Customer customer) throws ServiceLayerException {
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
    public List<Customer> findAllByIds(List<Integer> ids) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.findAllByIds(ids));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByName(String query) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.findAllByName(query));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByDoc(String query) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.findAllByDoc(query));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll(int limit) throws ServiceLayerException {
        return exceptionHandler(() -> customerRepository.findAll(limit));
    }
}
