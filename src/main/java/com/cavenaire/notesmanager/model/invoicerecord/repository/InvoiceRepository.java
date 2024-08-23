package com.cavenaire.notesmanager.model.invoicerecord.repository;

import com.cavenaire.notesmanager.model.EntityRepository;
import com.cavenaire.notesmanager.model.invoicerecord.InvoiceRecord;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

/**
 * Repository layer for {@code invoice records}.
 */
@Repository
@RequiredArgsConstructor
public class InvoiceRepository implements EntityRepository<InvoiceRecord> {

    private final JdbcTemplate jdbcTemplate;
    private final InvoiceMapper invoiceMapper = new InvoiceMapper();

    @Override
    public InvoiceRecord save(@NonNull InvoiceRecord invoiceRecord) {
        String sql = "INSERT INTO invoice_records(customer_id, created_on, subtotal, tax, total, status, comment)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"invoice_id"});
            ps.setLong(1, invoiceRecord.getCustomerId());
            ps.setString(2, invoiceRecord.getCreatedOn().toString());
            ps.setDouble(3, invoiceRecord.getSubtotal());
            ps.setDouble(4, invoiceRecord.getTax());
            ps.setDouble(5, invoiceRecord.getTotal());
            ps.setByte(6, invoiceRecord.getStatus());
            ps.setString(7, invoiceRecord.getComment());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) {
            throw new DataAccessResourceFailureException("Cannot get generated key");
        }

        invoiceRecord.setInvoiceId(keyHolder.getKey().longValue());
        return invoiceRecord;
    }

    @Override
    public void delete(@NonNull InvoiceRecord invoiceRecord) {
        String sql = "DELETE FROM invoice_records WHERE invoice_id = ?";
        jdbcTemplate.update(sql, invoiceRecord.getInvoiceId());
    }

    @Override
    public void update(@NonNull InvoiceRecord invoiceRecord) {
        String sql = "UPDATE invoice_records " +
                "SET customer_id = ?, created_on = ?, subtotal = ?, tax = ?, total = ?, status = ?, comment = ?" +
                "WHERE invoice_id = ?";
        jdbcTemplate.update(sql, invoiceRecord.getCustomerId(), invoiceRecord.getCreatedOn(), invoiceRecord.getSubtotal(),
                invoiceRecord.getTax(), invoiceRecord.getTotal(), invoiceRecord.getStatus(), invoiceRecord.getComment());
    }

    public int getCount() {
        String sql = "SELECT count(*) FROM invoice_records";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    public List<InvoiceRecord> findAllByIds(List<Long> ids) {
        String placeholders = String.join(",", Collections.nCopies(ids.size(), "?"));
        String sql = "SELECT * FROM invoice_records WHERE invoice_id IN (" + placeholders + ")";
        return jdbcTemplate.query(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 0; i < ids.size(); i++) {
                ps.setObject(i + 1, ids.get(i));
            }
            return ps;
        }, invoiceMapper);
    }

    public List<InvoiceRecord> findAllByCustomerId(Long id) {
        String sql = "SELECT * FROM invoice_records WHERE customer_id = ?";
        return jdbcTemplate.query(sql, invoiceMapper, id);
    }

    public List<InvoiceRecord> findAllByDate(String query, int limit) {
        String sql = "SELECT * FROM invoice_records " +
                "WHERE strftime('%d-%m-%Y', created_on, 'localtime') LIKE ? " +
                "ORDER BY date(created_on, 'localtime') DESC LIMIT ?";
        return jdbcTemplate.query(sql, invoiceMapper, query + "%", limit);
    }

    public List<InvoiceRecord> findAll(int limit) {
        String sql = "SELECT * FROM invoice_records ORDER BY date(created_on) DESC LIMIT ?";
        return jdbcTemplate.query(sql, invoiceMapper, limit);
    }
}
