package com.techelevator.dao;

import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> searchAndSortCustomers(String search, String sort){
        List<Customer> customerList = new ArrayList<>();
        String customerSearchSql = "SELECT first_name, last_name, email, activebool FROM customer " +
                "WHERE first_name ILIKE ? OR last_name ILIKE ?" +
                "ORDER BY ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(customerSearchSql, search, search, sort);
        while(results.next()) {
            customerList.add(mapRowToCustomer(results));
        }
        return customerList;
    }

    private Customer mapRowToCustomer(SqlRowSet results) {
        return new Customer(results.getString("first_name"),
                results.getString("last_name"),
                results.getString("email"),
                results.getBoolean("activebool"));
    }

}