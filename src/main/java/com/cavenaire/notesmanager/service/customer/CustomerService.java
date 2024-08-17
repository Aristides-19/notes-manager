package com.cavenaire.notesmanager.service.customer;

import com.cavenaire.notesmanager.model.Customer;
import com.cavenaire.notesmanager.service.EntityService;
import com.cavenaire.notesmanager.service.ServiceLayerException;

import java.util.List;

/**
 * Customer service specification, it extends from {@code EntityService}
 */
public interface CustomerService extends EntityService<Customer, Long> {

    /**
     * Get customer with the most recent interaction. <br/>
     * There is no case where a customer with this attribute doesn't exist.
     *
     * @return customer model object
     * @throws ServiceLayerException if it can't be gotten because a database exception cause
     */
    Customer getLastTimestamp() throws ServiceLayerException;

    /**
     * Find all customers by a pattern matching fullName query.
     *
     * @param query query to match
     * @return List of matched customers
     * @throws ServiceLayerException if it can't be found because a database exception cause
     */
    List<Customer> findAllByName(String query) throws ServiceLayerException;

    /**
     * Find all customers by a pattern matching document query.
     *
     * @param query query to match
     * @return List of matched customers
     * @throws ServiceLayerException if it can't be found because a database exception cause
     */
    List<Customer> findAllByDoc(String query) throws ServiceLayerException;
}
