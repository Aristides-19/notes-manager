package com.cavenaire.notesmanager.model.invoicerecord;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.invoiceproduct.InvoiceRecordProduct;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents an Invoice Record POJO Entity.
 */
@Getter
@Setter
@Builder
@ToString
public class InvoiceRecord {

    /**
     * Invoice Record's Primary Key ID.
     */
    private Long invoiceId;
    /**
     * Customer's Foreign Key ID who owns the invoice record.
     */
    private Long customerId;
    /**
     * Creation Datestamp. YYYY-MM-DD.
     */
    private LocalDate createdOn;
    /**
     * The tax base must be 16% of the total. Base Imponible – IVA
     */
    private double taxBase;
    /**
     * Total Amount in Bolivars – Bs. N
     */
    private double totalAmount;
    /**
     * Invoice Record's status. Zero(0) is DRAFT and One(1) is FINISHED.
     */
    private byte status;
    /**
     * Invoice Record's products.
     */
    private List<InvoiceRecordProduct> products;
    /**
     * Invoice Record's owner customer.
     */
    private Customer customer;

}
