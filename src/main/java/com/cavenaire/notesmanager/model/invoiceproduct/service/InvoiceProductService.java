package com.cavenaire.notesmanager.model.invoiceproduct.service;

import com.cavenaire.notesmanager.model.EntityService;
import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.model.invoiceproduct.InvoiceRecordProduct;
import com.cavenaire.notesmanager.model.invoiceproduct.repository.InvoiceProductRepository;

import static com.cavenaire.notesmanager.model.ServiceLayerException.*;

import org.springframework.lang.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for {@code invoice record products}.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceProductService implements EntityService<InvoiceRecordProduct> {

    private final InvoiceProductRepository productRepository;

    @Override
    public InvoiceRecordProduct save(@NonNull InvoiceRecordProduct product) throws ServiceLayerException {
        return exceptionHandler(() -> productRepository.save(product));
    }

    @Override
    public void delete(@NonNull InvoiceRecordProduct product) throws ServiceLayerException {
        exceptionHandler(() -> productRepository.delete(product));
    }

    @Override
    public void update(@NonNull InvoiceRecordProduct product) throws ServiceLayerException {
        exceptionHandler(() -> productRepository.update(product));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecordProduct> findAllByInvoiceId(Long id) throws ServiceLayerException {
        return exceptionHandler(() -> productRepository.findAllByInvoiceId(id));
    }
}
