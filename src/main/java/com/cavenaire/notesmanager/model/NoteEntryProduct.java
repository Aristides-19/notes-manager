package com.cavenaire.notesmanager.model;

import lombok.*;

/**
 * Represents a Note Entry Product POJO Entity.
 */
@Getter
@Setter
@Builder
@ToString
public class NoteEntryProduct {

    /**
     * Product's Primary Key ID.
     */
    private Long productId;
    /**
     * Note Entry's Foreign Key ID that owns the product.
     */
    private Long noteId;
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
    private double priceBs;
    /**
     * Product's Price in USD Dollars – N $
     */
    private double priceUsd;

}
