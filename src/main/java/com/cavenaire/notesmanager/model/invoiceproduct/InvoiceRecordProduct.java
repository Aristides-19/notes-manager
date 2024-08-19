package com.cavenaire.notesmanager.model.invoiceproduct;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an Invoice Record Product POJO Entity.
 */
@Getter
@Setter
@Builder
@ToString
public class InvoiceRecordProduct {

    /**
     * Product's Primary Key ID.
     */
    private Long productId;
    /**
     * Invoice Record's Foreign Key ID that owns the product.
     */
    private Long invoiceId;
    /**
     * Product's quantity int number.
     */
    private int quantity;
    /**
     * Product's description.
     */
    private String description;
    /**
     * Product's Price in Bolivars – Bs. N
     */
    private double price;

}
