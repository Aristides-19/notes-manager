package com.cavenaire.notesmanager.view.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * It provides static methods to valid data for adding entity fields.
 */
public class Validator {

    static public boolean checkFullName(String name) {
        return name.split("\\s+").length > 1;
    }

    static public boolean checkDocument(String doc) {
        var normalizedDoc = doc.replaceAll("\\D", "");
        int length = normalizedDoc.length();
        return length >= 7 && length <= 9;
    }

    static public boolean checkContact(String contact) {
        var normalizedPhone = contact.replaceAll("\\D", "");
        int length = normalizedPhone.length();
        return length == 11 && (normalizedPhone.startsWith("02") || normalizedPhone.startsWith("04"));
    }

    static public boolean checkDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
