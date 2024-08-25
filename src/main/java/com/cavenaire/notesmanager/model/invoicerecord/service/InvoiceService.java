package com.cavenaire.notesmanager.model.invoicerecord.service;

import com.cavenaire.notesmanager.model.EntityService;
import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.model.customer.service.CustomerService;
import com.cavenaire.notesmanager.model.invoiceproduct.service.InvoiceProductService;
import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.model.invoicerecord.repository.InvoiceRepository;

import static com.cavenaire.notesmanager.model.ServiceLayerException.*;

import org.springframework.lang.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for {@code invoice record}.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceService implements EntityService<InvoiceRecord> {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductService productService;
    @Setter(onMethod_ = @Autowired, onParam_ = @Lazy)
    private CustomerService customerService;

    @Override
    public InvoiceRecord save(@NonNull InvoiceRecord invoiceRecord) throws ServiceLayerException {
        return exceptionHandler(() -> invoiceRepository.save(invoiceRecord));
    }

    @Override
    public void delete(@NonNull InvoiceRecord invoiceRecord) throws ServiceLayerException {
        exceptionHandler(() -> invoiceRepository.delete(invoiceRecord));
    }

    @Override
    public void update(@NonNull InvoiceRecord invoiceRecord) throws ServiceLayerException {
        exceptionHandler(() -> invoiceRepository.update(invoiceRecord));
    }

    @Transactional(readOnly = true)
    public int getCount() {
        return exceptionHandler(invoiceRepository::getCount);
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAllByIds(List<Long> ids) {
        return exceptionHandler(() -> invoiceRepository.findAllByIds(ids));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAllByCustomerId(Long id) {
        return exceptionHandler(() -> invoiceRepository.findAllByCustomerId(id));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAllByDate(String query, int limit) {
        return exceptionHandler(() -> findInvoicesCustomers(invoiceRepository.findAllByDate(query, limit)));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAll(int limit) {
        return exceptionHandler(() -> findInvoicesCustomers(invoiceRepository.findAll(limit)));
    }

    private List<InvoiceRecord> findInvoicesCustomers(List<InvoiceRecord> invoices) {
        invoices.forEach(invoice -> {
            var customer = customerService.getById(invoice.getCustomerId());
            invoice.setCustomer(customer);
            if (customer.getInvoiceRecords() == null) {
                customer.setInvoiceRecords(new ArrayList<>());
            }
            customer.getInvoiceRecords().add(invoice);
            invoice.setProducts(productService.findAllByInvoiceId(invoice.getInvoiceId()));
        });
        return invoices;
    }
}
