package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.springbootacademy.pointofsale.service.CustomerService;
import com.springbootacademy.pointofsale.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        /*
        __Past Method___
        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
        customerServiceIMPL.saveCustomer(customerDTO);
        ----USE DEPENDANCY INJECTION------
        */
        customerService.saveCustomer(customerDTO);
        return "save";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody RequestUpdateCustomerDTO customerDTO){
        String updated = customerService.updateCustomer(customerDTO);
        return updated;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "Id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "Id") int customerId){
        //System.out.println("Customer Id is"+customerId);
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

}
