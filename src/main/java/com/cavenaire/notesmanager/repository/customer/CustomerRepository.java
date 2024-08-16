package com.cavenaire.notesmanager.repository.customer;

import com.cavenaire.notesmanager.model.Customer;
import com.cavenaire.notesmanager.repository.EntityRepository;

import java.util.List;

/**
 * Customer repository specification, it extends from {@code EntityRepository}.
 */
public interface CustomerRepository extends EntityRepository<Customer, Long> {

    /**
     * Select the costumer with the most recent timestamp.
     *
     * @return a Customer POJO
     */
    Customer getLastTimestamp();

    /**
     * It performs a full-text search query by {@code fullName} using a trigram.
     * It doesn't use the trigram if query length is less than three.
     *
     * @param query query to perform by {@code fullName}
     * @return list of matched customers
     */
    List<Customer> findAllByName(String query);

    /**
     * It performs a full-text search query by {@code document} using a trigram.
     * It doesn't use the trigram if query length is less than three.
     *
     * @param query query to perform by {@code document}
     * @return list of matched customers
     */
    List<Customer> findAllByDoc(String query);
}
