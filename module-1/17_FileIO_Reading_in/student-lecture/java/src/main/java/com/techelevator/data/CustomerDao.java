package com.techelevator.data;

import com.techelevator.entity.Customer;

import java.util.List;

public interface CustomerDao {

    /**
     * Loads Customer list from a file.
     * @param fileName
     * @param delimiter
     * @throws Exception if error while loading customers from file
     */
    void loadCustomers(String fileName, String delimiter) throws Exception;

    /**
     * Returns the customer that matches the unique id.
     *
     * @param id
     * @return the Customer found for given id or a null value
     */
    Customer getCustomer(int id);

    /**
     * Updates if customer already exists, otherwise inserts.
     *
     * @param customer
     * @return the Customer inserted or updated
     */
    Customer add(Customer customer);

    /**
     * Removes the customer.
     *
     * @param customer
     * @return the Customer removed or null if customer does not exist
     */
    default Customer remove(Customer customer) { return null;}
}
