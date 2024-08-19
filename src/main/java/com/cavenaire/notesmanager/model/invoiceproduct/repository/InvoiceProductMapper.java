package com.cavenaire.notesmanager.model.invoiceproduct.repository;

import com.cavenaire.notesmanager.model.invoiceproduct.InvoiceRecordProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceProductMapper implements RowMapper<InvoiceRecordProduct> {
    @Override
    public InvoiceRecordProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        return InvoiceRecordProduct.builder()
                .productId(rs.getLong("product_id"))
                .invoiceId(rs.getLong("invoice_id"))
                .quantity(rs.getInt("quantity"))
                .description(rs.getString("description"))
                .price(rs.getDouble("price"))
                .build();
    }
}
