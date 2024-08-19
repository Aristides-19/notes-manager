package com.cavenaire.notesmanager.model.invoicerecord.service;

import com.cavenaire.notesmanager.model.EntityService;
import com.cavenaire.notesmanager.model.ServiceLayerException;
import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.model.invoicerecord.repository.InvoiceRepository;

import static com.cavenaire.notesmanager.model.ServiceLayerException.*;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceService implements EntityService<InvoiceRecord> {

    private final InvoiceRepository invoiceRepository;

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
    public List<InvoiceRecord> findAllByIds(List<Integer> ids) {
        return exceptionHandler(() -> invoiceRepository.findAllByIds(ids));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAllByCustomerIds(List<Integer> ids) {
        return exceptionHandler(() -> invoiceRepository.findAllByCustomerIds(ids));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAllByDate(String query, int limit) {
        return exceptionHandler(() -> invoiceRepository.findAllByDate(query, limit));
    }

    @Transactional(readOnly = true)
    public List<InvoiceRecord> findAll(int limit) {
        return exceptionHandler(() -> invoiceRepository.findAll(limit));
    }
}
