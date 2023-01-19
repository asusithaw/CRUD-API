package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveState()
        );

        if (customerRepo.existsById(customer.getCustomerId())) {
           throw new DuplicateKeyException("Customer Already exists");
       } else {
            customerRepo.save(customer);
            return customer.getCustomerName() + "Saved";
        }

    }

    @Override
    public String updateCustomer(RequestUpdateCustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customerRepo.save(customer);
            return "Saved" + customer.getCustomerId() + " " + customer.getCustomerName();
        } else {
            throw new RuntimeException("Customer Not in Database");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        /*Customer customer = customerRepo.getById(customerId);
        //Next we have to convert the Entity to DTO type to return to the front-end.(Understand vice-versa)
        if (customer!=null) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            return customerDTO;
        }else{
            throw new RuntimeException("No Customer Found In THat Id" +customerId);

        }


    }*/
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()){
            CustomerDTO customerDTO;
            customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;
        }else
            throw new RuntimeException("Customer Not Found");
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomers = customerRepo.findAll();
        return null;
    }
}

