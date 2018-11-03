package net.playground.reactive.mongodbdemo.rest.controller;

import net.playground.reactive.mongodbdemo.database.StorageService;
import net.playground.reactive.mongodbdemo.model.Customer;
import net.playground.reactive.mongodbdemo.rest.validation.RequestValidator;
import net.playground.reactive.mongodbdemo.rest.model.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final StorageService storageService;

    public CustomerController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    RestResponse getCustomer(@PathVariable(name = "id") String id) {
        RequestValidator.validate(id);
        logger.debug("Requested customer-id: {}", id);
        return storageService.getCustomer(id);
    }

    @PostMapping(value = "/save")
    public @ResponseBody RestResponse saveCustomer(@RequestBody Customer customer) {
        RequestValidator.validate(customer);
        return storageService.saveCustomer(customer);
    }

}
