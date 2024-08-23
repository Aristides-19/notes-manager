package com.cavenaire.notesmanager.model.invoicerecord;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.invoiceproduct.InvoiceRecordProduct;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
     * The subtotal amount, it is the tax base. Base Imponible
     */
    @Setter(AccessLevel.NONE)
    private double subtotal;
    /**
     * Invoice's tax, it is 16% of subtotal amount.
     */
    @Setter(AccessLevel.NONE)
    private double tax;
    /**
     * Total Amount in Bolivars – Bs. N. <br/>
     * Sum of subtotal + tax
     */
    @Setter(AccessLevel.NONE)
    private double total;
    /**
     * Invoice Record's status. Zero(0) is DRAFT and One(1) is FINISHED.
     */
    private byte status;
    /**
     * Invoice Record's optional comment at the invoice's endline.
     */
    private String comment;
    /**
     * Invoice Record's products.
     */
    private List<InvoiceRecordProduct> products;
    /**
     * Invoice Record's owner customer.
     */
    private Customer customer;

    /**
     * Add product to the product list. It calls {@code updateAmounts} after insertion.
     *
     * @param product product to be added
     */
    public void addProduct(InvoiceRecordProduct product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        updateAmounts();
    }

    /**
     * Updates subtotal, tax and total amounts. It is auto-called after {@code addProduct} operation.
     */
    public void updateAmounts() {
        subtotal = products.stream().mapToDouble(InvoiceRecordProduct::getPrice).sum();
        tax = subtotal * 0.16;
        total = subtotal + tax;
    }
}
