package com.cavenaire.notesmanager.model.noteproduct;

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
     * Product's Unit Price in USD – N $
     */
    private double unitPrice;

    /**
     * Product's Total Price in USD – N$, based in quantity.
     */
    public double getPrice() {
        return quantity * unitPrice;
    }
}
