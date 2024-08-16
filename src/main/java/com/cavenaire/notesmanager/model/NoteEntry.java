package com.cavenaire.notesmanager.model;

import lombok.*;

import java.time.LocalDate;

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
     * Total Amount in Bolivars – Bs. N
     */
    private double totalAmountBs;
    /**
     * Total Amount in USD Dollars – N $
     */
    private double totalAmountUsd;
    /**
     * Invoice Entry's status. Zero(0) is DRAFT and One(1) is FINISHED.
     */
    private byte status;

}
