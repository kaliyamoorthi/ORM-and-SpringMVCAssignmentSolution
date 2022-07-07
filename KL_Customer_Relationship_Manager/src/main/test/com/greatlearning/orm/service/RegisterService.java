package com.greatlearning.orm.service;


import com.greatlearning.orm.model.Customer;
import com.greatlearning.orm.Repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service

public class RegisterService {
    @Autowired
    private final CustomerRepo customerRepo;
    public RegisterService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer registerCustomer(Customer customer){
        return this.customerRepo.registerCustomer(customer);
    }
    public List<Customer> getRegisterCustomer(){
        return this.customerRepo.getRegisterCustomer();
    }
    public Customer updateCustomerDetails(Serializable id, Customer customer){
        return this.customerRepo.updateCustomerDetails((int)id,customer);
    }
    public void deleteCustomer(int id){
        System.out.println("Student with the following Id is deleted: "+ id);
        this.customerRepo.deleteCustomerById(id);
        return;
    }

    public Customer getCustomer(int id) {
        return this.customerRepo.getCustomerById(id);
    }
}

