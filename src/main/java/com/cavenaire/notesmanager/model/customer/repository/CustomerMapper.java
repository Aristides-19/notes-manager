package com.cavenaire.notesmanager.model.customer.repository;

import com.cavenaire.notesmanager.model.customer.Customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Customer.builder()
                .customerId(rs.getLong("customer_id"))
                .fullName(rs.getString("full_name"))
                .document(rs.getString("document"))
                .contact(rs.getString("contact"))
                .address(rs.getString("address"))
                .lastTimestamp(LocalDateTime.parse(rs.getString("last_timestamp"), DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }
}
