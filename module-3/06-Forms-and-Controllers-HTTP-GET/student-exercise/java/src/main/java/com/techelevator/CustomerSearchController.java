package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    /* What request mapping do we want here */
    @RequestMapping("/searchCustomerForm")
    public String showSearchCustomerForm() {
        return "customerList";
    }

    @RequestMapping("/searchCustomers")
    public String searchCustomer(@RequestParam String searchName, @RequestParam String sortBy, ModelMap modelmap) {
        List<Customer> customers = customerDao.searchAndSortCustomers(searchName, sortBy);
        modelmap.put("customerListResults", customers);
        return "customerList";
    }

}