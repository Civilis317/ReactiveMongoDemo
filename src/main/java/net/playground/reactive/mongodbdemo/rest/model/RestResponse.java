package net.playground.reactive.mongodbdemo.rest.model;

import net.playground.reactive.mongodbdemo.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class RestResponse {
    private int count;
    private int page;
    private List<Customer> data = new ArrayList<>(16);

    // convenience method
    public void addCustomer(Customer customer) {
        this.data.add(customer);
    }

    // getters and setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
}
