package com.gchsj.h2jpav1.runner;

import com.gchsj.h2jpav1.data.City;
import com.gchsj.h2jpav1.data.CityRepository;
import com.gchsj.h2jpav1.data.CityRepositorySupport;
import com.gchsj.h2jpav1.data.QCity;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Order(2)
@Component
public class QDRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private CityRepositorySupport cityRepositorySupport;

    private final CityRepository cityRepository;

    public QDRunner(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<City> cities = (List<City>) cityRepository.findAll();

        cities.forEach(city -> System.out.println(city.toString()));

//        cityRepositorySupport.findByName("Suzhou");
    }
}
