package com.cavenaire.notesmanager.service.customer;

import com.cavenaire.notesmanager.model.Customer;
import com.cavenaire.notesmanager.repository.customer.CustomerRepositoryImpl;
import com.cavenaire.notesmanager.service.ServiceLayerException;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Layer for {@code customers}.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    public Customer save(@NonNull Customer customer) throws ServiceLayerException {
        try {
            return customerRepository.save(customer);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to save customer, should try again", e);
        }
    }

    public void delete(@NonNull Customer customer) throws ServiceLayerException {
        deleteById(customer.getCustomerId());
    }

    public void deleteById(Long id) throws ServiceLayerException {
        try {
            customerRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to delete customer, should try again", e);
        }
    }

    public void update(@NonNull Customer customer) throws ServiceLayerException {
        try {
            customerRepository.update(customer);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to update customer, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public Customer getById(Long id) throws ServiceLayerException {
        try {
            return customerRepository.getById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceLayerException("There is no customer with ID: " + id, e);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customer, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public int getCount() throws ServiceLayerException {
        try {
            return customerRepository.getCount();
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customer, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public Customer getLastTimestamp() throws ServiceLayerException {
        try {
            return customerRepository.getLastTimestamp();
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customer, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByName(String query) throws ServiceLayerException {
        try {
            return customerRepository.findAllByName(query);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customers, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> findAllByDoc(String query) throws ServiceLayerException {
        try {
            return customerRepository.findAllByDoc(query);
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customers, should try again", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() throws ServiceLayerException {
        try {
            return customerRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceLayerException("Failed to get customers, should try again,", e);
        }
    }
}
