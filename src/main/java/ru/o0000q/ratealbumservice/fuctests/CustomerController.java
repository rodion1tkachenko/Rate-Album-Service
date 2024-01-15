package ru.o0000q.ratealbumservice.fuctests;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.o0000q.ratealbumservice.fuctests.Customer;
import ru.o0000q.ratealbumservice.fuctests.CustomerRepository;

@RestController
class CustomerController {

    private final CustomerRepository repo;

    CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/customers")
    List<Customer> getAll() {
        return repo.findAll();
    }
}