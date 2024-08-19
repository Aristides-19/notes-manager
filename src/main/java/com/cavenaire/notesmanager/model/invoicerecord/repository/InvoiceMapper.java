package com.cavenaire.notesmanager.model.invoicerecord.repository;

import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InvoiceMapper implements RowMapper<InvoiceRecord> {
    @Override
    public InvoiceRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        return InvoiceRecord.builder()
                .invoiceId(rs.getLong("invoice_id"))
                .customerId(rs.getLong("customer_id"))
                .createdOn(LocalDate.parse(rs.getString("created_on"), DateTimeFormatter.ISO_DATE_TIME))
                .taxBase(rs.getDouble("tax_base"))
                .totalAmount(rs.getDouble("total"))
                .status(rs.getByte("status"))
                .build();
    }
}
