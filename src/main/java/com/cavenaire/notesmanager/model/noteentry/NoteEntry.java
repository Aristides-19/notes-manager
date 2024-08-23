package com.cavenaire.notesmanager.model.noteentry;

import com.cavenaire.notesmanager.model.customer.Customer;
import com.cavenaire.notesmanager.model.noteproduct.NoteEntryProduct;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Note Entry POJO Entity.
 */
@Getter
@Setter
@Builder
@ToString
public class NoteEntry {

    /**
     * Note Entry's Primary Key ID.
     */
    private Long noteId;
    /**
     * Customer's Foreign Key ID who owns the note entry.
     */
    private Long customerId;
    /**
     * Creation Datestamp. YYYY-MM-DD.
     */
    private LocalDate createdOn;
    /**
     * Note Entry's total price in USD – N $
     */
    @Setter(AccessLevel.NONE)
    private double total;
    /**
     * Invoice Entry's status. Zero(0) is DRAFT and One(1) is FINISHED.
     */
    private byte status;
    /**
     * Note Entry's optional comment at the note's endline.
     */
    private String comment;
    /**
     * Note Entry's products.
     */
    private List<NoteEntryProduct> products;
    /**
     * Note Entry's customer.
     */
    private Customer customer;

    /**
     * Add a product to the product list. It calls {@code updateTotal} after insertion.
     *
     * @param product product to be added
     */
    public void addProduct(NoteEntryProduct product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        updateTotal();
    }

    /**
     * Updates total amount. It is called after an {@code addProduct} operation.
     */
    public void updateTotal() {
        total = products.stream().mapToDouble(NoteEntryProduct::getPrice).sum();
    }
}
