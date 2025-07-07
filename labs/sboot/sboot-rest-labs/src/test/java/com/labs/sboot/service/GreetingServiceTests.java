package com.labs.sboot.service;

import com.labs.sboot.exception.NoGreetingsFoundException;
import com.labs.sboot.model.Greetings;
import com.labs.sboot.repository.GreetingsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GreetingServiceTests {

    @MockitoBean
    GreetingsRepository greetingsRepo;

    @Autowired
    GreetingService greetingService;

    // Test case for finding greetings by message
    @Test
    public void testSearchGreeting() throws NoGreetingsFoundException {
        Mockito.when(greetingsRepo.searchMessages("Hello")).thenReturn(List.of(new Greetings()));

        // Arrange
        String message = "Hello, World!";
        Greetings greeting = new Greetings(100, message);
        greetingsRepo.save(greeting);

        // Act
        Collection<Greetings> greetings = greetingService.searchGreetings("Hello");

        // Assert
       assertEquals(1, greetings.size());

    }
}
