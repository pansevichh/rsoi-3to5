package by.rest.carsharing;

import by.rest.carsharing.entities.Person;
import by.rest.carsharing.entities.Travel;
import by.rest.carsharing.entities.Violation;
import by.rest.carsharing.repositories.PersonRepository;
import by.rest.carsharing.repositories.TravelRepository;
import by.rest.carsharing.repositories.ViolationRepository;
import jakarta.persistence.SecondaryTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, ViolationRepository violationRepository, TravelRepository travelRepository) {
        return args -> {
            Person person1 = new Person("Stefania", 20, 2);
            log.info("Preloading " + personRepository.save(person1));
            Violation violation1 = new Violation("Violation1", new Date());
            violation1.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation1));

            Violation violation2 = new Violation("Violation2", new Date());
            violation2.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation2));

            Violation violation3 = new Violation("Violation3", new Date());
            violation3.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation3));
//////////////
            Travel travel1 = new Travel("Travel1", new Date());
            travel1.setPerson(person1);
            log.info("Preloading " + travelRepository.save(travel1));

            Travel travel2 = new Travel("travel2", new Date());
            travel2.setPerson(person1);
            log.info("Preloading " + travelRepository.save(travel2));

            Travel travel3 = new Travel("travel3", new Date());
            travel3.setPerson(person1);
            log.info("Preloading " + travelRepository.save(travel3));

            log.info("Preloading " + person1);


            Person person2 = new Person("Vladislau", 22, 3);
            log.info("Preloading " + personRepository.save(person2));
            Travel travel10 = new Travel("Violation10", new Date());
            travel10.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel10));

            Travel travel20 = new Travel("Violation20", new Date());
            travel20.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel20));

            Travel travel30 = new Travel("Violation30", new Date());
            travel30.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel30));

            log.info("Preloading " + person2);
        };
    }
}
