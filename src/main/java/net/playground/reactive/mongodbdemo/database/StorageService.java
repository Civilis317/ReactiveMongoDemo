package net.playground.reactive.mongodbdemo.database;

import net.playground.reactive.mongodbdemo.model.Customer;
import net.playground.reactive.mongodbdemo.rest.exceptions.CustomerNotFoundException;
import net.playground.reactive.mongodbdemo.rest.model.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    private final CustomerRepository repository;

    public StorageService(CustomerRepository repository) {
        this.repository = repository;
    }

    public RestResponse getCustomer(String id) {
        RestResponse response = new RestResponse();
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for id = " + id));
        response.addCustomer(customer);
        response.setCount(response.getData().size());
        response.setPage(1);
        return response;
    }

    public RestResponse saveCustomer(Customer customer) {
        RestResponse response = new RestResponse();
        Customer result = repository.save(customer);
        response.addCustomer(result);
        response.setCount(response.getData().size());
        response.setPage(1);
        return response;
    }
}
