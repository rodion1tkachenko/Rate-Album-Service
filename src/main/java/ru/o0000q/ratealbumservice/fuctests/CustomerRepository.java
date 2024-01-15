package ru.o0000q.ratealbumservice.fuctests;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.o0000q.ratealbumservice.fuctests.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}