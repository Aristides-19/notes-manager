package com.cavenaire.notesmanager.model.customer;

import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;
import com.cavenaire.notesmanager.model.noteentry.NoteEntry;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a Customer POJO Entity.
 */
@Getter
@Setter
@Builder
@ToString
public class Customer {

    /**
     * Customer's Primary Key ID.
     */
    private Long customerId;
    /**
     * Customer's First and Last Names.
     */
    private String fullName;
    /**
     * Customer's Document Identification. Format V[E]-XX.XXX.XXX or J-XXXXXXXX-X.
     */
    private String document;
    /**
     * Customer's Phone Contact. Format 0XXX-XXX-XXXX or XXX-XXX.
     */
    private String contact;
    /**
     * Customer's Second Phone Contact. This is totally optional.
     */
    private String secondContact;
    /**
     * Customer's Address.
     */
    private String address;
    /**
     * Customer's last update timestamp. It is updated when an invoice or note entry creation.
     */
    private LocalDateTime lastTimestamp;
    /**
     * Customer's invoice records.
     */
    private List<InvoiceRecord> invoiceRecords;
    /**
     * Customer's note entries.
     */
    private List<NoteEntry> noteEntries;

}
