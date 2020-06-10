package com.gchsj.h2jpav1.runner;

import com.gchsj.h2jpav1.data.City;
import com.gchsj.h2jpav1.data.CityRepository;
import com.gchsj.h2jpav1.data.Customer;
import com.gchsj.h2jpav1.data.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DBRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DBRunner.class);

    private final CustomerRepository customerRepository;

    private final CityRepository cityRepository;

    public DBRunner(CustomerRepository customerRepository, CityRepository cityRepository) {
        this.customerRepository = customerRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // save a few customers
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        Customer customer = customerRepository.findById(1L);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        customerRepository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
        // for (Customer bauer : repository.findByLastName("Bauer")) {
        //  log.info(bauer.toString());
        // }
        log.info("");


        cityRepository.save(new City("Bratislava", 432000));
        cityRepository.save(new City("Budapest", 1759000));
        cityRepository.save(new City("Prague", 1280000));
        cityRepository.save(new City("Warsaw", 1748000));
        cityRepository.save(new City("Los Angeles", 3971000));
        cityRepository.save(new City("New York", 8550000));
        cityRepository.save(new City("Edinburgh", 464000));
        cityRepository.save(new City("Suzhou", 4327066));
        cityRepository.save(new City("Zhengzhou", 4122087));
        cityRepository.save(new City("Berlin", 3671000));
        cityRepository.save(new City("Brest", 139163));
        cityRepository.save(new City("Bucharest", 1836000));

    };

}
