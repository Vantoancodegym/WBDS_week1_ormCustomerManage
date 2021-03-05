package service;

import model.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findAll();

    Customer findById(int id);

    Customer update(Customer customer);

    Customer save(Customer customer);

    void remove(int id);
}
