package com.cavenaire.notesmanager.model.invoiceproduct.repository;

import com.cavenaire.notesmanager.model.EntityRepository;
import com.cavenaire.notesmanager.model.invoiceproduct.InvoiceRecordProduct;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Repository layer for {@code invoice products}
 */
@Repository
@RequiredArgsConstructor
public class InvoiceProductRepository implements EntityRepository<InvoiceRecordProduct> {

    private final JdbcTemplate jdbcTemplate;
    private final InvoiceProductMapper productMapper = new InvoiceProductMapper();

    @Override
    public InvoiceRecordProduct save(@NonNull InvoiceRecordProduct product) {
        String sql = "INSERT INTO invoice_record_products(invoice_id, quantity, description, unit_price_bs)" +
                "VALUES (?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"product_id"});
            ps.setLong(1, product.getInvoiceId());
            ps.setInt(2, product.getQuantity());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getUnitPrice());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) {
            throw new DataAccessResourceFailureException("Cannot get generated key");
        }

        product.setInvoiceId(keyHolder.getKey().longValue());
        return product;
    }

    @Override
    public void delete(@NonNull InvoiceRecordProduct product) {
        String sql = "DELETE FROM invoice_record_products WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getInvoiceId());
    }

    @Override
    public void update(@NonNull InvoiceRecordProduct product) {
        String sql = "UPDATE invoice_record_products " +
                "SET invoice_id = ?, quantity = ?, description = ?, unit_price_bs = ?" +
                "WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getInvoiceId(), product.getQuantity(), product.getDescription(),
                product.getUnitPrice(), product.getProductId());
    }

    public List<InvoiceRecordProduct> findAllByInvoiceId(Long id) {
        String sql = "SELECT * FROM invoice_record_products WHERE invoice_id = ?";
        return jdbcTemplate.query(sql, productMapper, id);
    }
}
