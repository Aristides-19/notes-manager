package com.cavenaire.notesmanager.repository.customer;

import com.cavenaire.notesmanager.model.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import lombok.NonNull;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerMapperImpl customerMapper = new CustomerMapperImpl();

    public Customer save(@NonNull Customer entity) {
        String sql = "INSERT INTO customers(full_name, document, contact, second_contact, address, last_timestamp)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"customer_id"});
            ps.setString(1, entity.getFullName());
            ps.setString(2, entity.getDocument());
            ps.setString(3, entity.getContact());
            ps.setString(4, entity.getSecondContact());
            ps.setString(5, entity.getAddress());
            ps.setString(6, entity.getLastTimestamp().toString());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) {
            throw new DataAccessResourceFailureException("Cannot get generated key");
        }

        entity.setCustomerId(keyHolder.getKey().longValue());
        return entity;
    }

    public void delete(@NonNull Customer entity) {
        deleteById(entity.getCustomerId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(@NonNull Customer entity) {
        String sql = "UPDATE customers " +
                "SET full_name = ?, document = ?, contact = ?, second_contact = ?, address = ?, last_timestamp = ?" +
                "WHERE customer_id = ?";
        jdbcTemplate.update(sql, entity.getFullName(), entity.getDocument(), entity.getContact(), entity.getSecondContact(),
                entity.getAddress(), entity.getLastTimestamp(), entity.getCustomerId());
    }

    public Optional<Customer> getById(Long id) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, customerMapper, id);
        return Optional.ofNullable(customer);
    }

    public Customer getLastTimestamp() {
        String sql = "SELECT * FROM customers ORDER BY datetime(last_timestamp) DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, customerMapper);
    }

    public int getCount() {
        String sql = "SELECT count(*) FROM customers";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    public List<Customer> findAllByName(String query) {
        String queryType = query.length() < 3 ? "LIKE ?)" : "MATCH ?)";
        String escapedQuery = String.format("\"%s\"", query);
        String sql = "SELECT * FROM customers WHERE customer_id IN " +
                "(SELECT rowid FROM trigram_customers WHERE full_name " + queryType;
        return jdbcTemplate.query(sql, customerMapper, escapedQuery);
    }

    public List<Customer> findAllByDoc(String query) {
        String queryType = query.length() < 3 ? "LIKE ?)" : "MATCH ?)";
        String escapedQuery = String.format("\"%s\"", query);
        String sql = "SELECT * FROM customers WHERE customer_id IN " +
                "(SELECT rowid FROM trigram_customers WHERE document " + queryType;
        return jdbcTemplate.query(sql, customerMapper, escapedQuery);
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, customerMapper);
    }
}
