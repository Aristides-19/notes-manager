package com.cavenaire.notesmanager.view.handlers.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * It provides static methods to valid data for adding entity fields.
 */
public class ValidationUtils {

    static public String formatName(String name) {
        return Arrays.stream(name.split(" "))
                .map(w -> {
                    if (w.isEmpty()) return w;
                    if (w.matches("(?i)c\\.?a\\.?\\.?")) return "C.A.";
                    return Character.toTitleCase(w.charAt(0)) + w.substring(1).toLowerCase();
                })
                .collect(Collectors.joining(" "));
    }

    static public boolean isNameValid(String name) {
        return name.split(" ").length > 1;
    }

    static public String formatDoc(String doc) {
        var normalizedDoc = doc.replaceAll("\\D", "");
        return switch (normalizedDoc.length()) {
            case 7, 8 -> normalizedDoc.replaceFirst("(\\d{1,2})(\\d{3})(\\d{3})", "$1.$2.$3");
            case 9 -> normalizedDoc.replaceFirst("(\\d{8})(\\d)", "$1-$2");
            default -> normalizedDoc;
        };
    }

    static public boolean isDocValid(String doc) {
        var normalizedDoc = doc.replaceAll("\\D", "");
        int length = normalizedDoc.length();
        return length >= 7 && length <= 9;
    }

    static public String formatAddress(String address) {
        return formatName(address);
    }

    static public String formatContact(String contact) {
        var normalizedPhone = contact.replaceAll("\\D", "");
        return switch (normalizedPhone.length()) {
            case 11 -> normalizedPhone.replaceFirst("(\\d{4})(\\d{7})", "$1-$2");
            case 10 -> normalizedPhone.replaceFirst("(\\d{3})(\\d{7})", "0$1-$2");
            case 7 -> "0212-" + normalizedPhone;
            default -> normalizedPhone;
        };
    }

    static public boolean isContactValid(String contact) {
        var normalizedPhone = contact.replaceAll("\\D", "");
        int length = normalizedPhone.length();
        return length == 11 && (normalizedPhone.startsWith("02") || normalizedPhone.startsWith("04"));
    }

    static public String formatDate(String date) {
        var normalizedDate = date.replaceAll("\\D", "");
        return normalizedDate.length() == 8 ? normalizedDate.replaceFirst("(\\d{2})(\\d{2})(\\d{4})", "$1-$2-$3") : normalizedDate;
    }

    static public boolean isDateValid(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
