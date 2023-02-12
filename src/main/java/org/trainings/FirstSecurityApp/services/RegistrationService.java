package org.trainings.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.trainings.FirstSecurityApp.models.Person;
import org.trainings.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void register(Person person){
        String encodedPassword= passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        peopleRepository.save(person);

    }
}
