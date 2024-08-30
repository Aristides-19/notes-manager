package com.cavenaire.notesmanager.view.utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * It provides static methods to format models states/atrributes.
 */
public class Formatter {

    static public String formatName(String name) {
        return Arrays.stream(name.strip().split("\\s+"))
                .map(w -> {
                    if (w.matches("(?i)c\\.?a\\.?\\.?")) return "C.A.";
                    return Character.toTitleCase(w.charAt(0)) + w.substring(1).toLowerCase();
                })
                .collect(Collectors.joining(" "));
    }

    static public String formatDoc(String doc) {
        var normalizedDoc = doc.replaceAll("\\D", "");
        return switch (normalizedDoc.length()) {
            case 7, 8 -> normalizedDoc.replaceFirst("(\\d{1,2})(\\d{3})(\\d{3})", "$1.$2.$3");
            case 9 -> normalizedDoc.replaceFirst("(\\d{8})(\\d)", "$1-$2");
            default -> normalizedDoc;
        };
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

    static public String formatAddress(String address) {
        return Arrays.stream(address.strip().split("\\s+"))
                .map(w -> {
                    if (NON_FORMATABLE_ADDRESS.matcher(w).matches()) return w.toLowerCase();
                    return Character.toTitleCase(w.charAt(0)) + w.substring(1).toLowerCase();
                })
                .collect(Collectors.joining(" "));
    }

    static public String formatDate(String date) {
        var normalizedDate = date.replaceAll("\\D", "");
        return normalizedDate.length() == 8 ? normalizedDate.replaceFirst("(\\d{2})(\\d{2})(\\d{4})", "$1-$2-$3") : normalizedDate;
    }

    static public String formatBsCurrency(double amount) {
        return "Bs. " + CURRENCY_FORMATTER.format(amount);
    }

    private static final Pattern NON_FORMATABLE_ADDRESS = Pattern.compile("\\b(?:de|del|y|en|con|entre|a|hacia|por|sobre|tras|para|frente)\\b", Pattern.CASE_INSENSITIVE);
    private static final NumberFormat CURRENCY_FORMATTER;

    static {
        CURRENCY_FORMATTER = NumberFormat.getNumberInstance();
        CURRENCY_FORMATTER.setMaximumFractionDigits(2);
    }

}
