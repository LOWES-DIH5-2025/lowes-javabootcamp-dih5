package com.labs.sboot.repository;

import com.labs.sboot.model.Greetings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GreetingsRepositoryTests {

    // test case for finding greetings by message
    @Autowired
    private GreetingsRepository greetingsRepository;

    @Test
    public void testFindByMessageContains() {
        // Arrange
        String message = "Hello, World!";
        Greetings greeting = new Greetings(100,message);
        greetingsRepository.save(greeting);

        // Act
        List<Greetings> foundGreetings = greetingsRepository.findByMessageContains("Hello");

        // Assert
        assertThat(foundGreetings).hasSize(1);
    }

}
