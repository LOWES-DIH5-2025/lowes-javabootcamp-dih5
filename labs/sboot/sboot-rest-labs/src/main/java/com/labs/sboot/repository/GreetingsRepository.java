package com.labs.sboot.repository;

import com.labs.sboot.model.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GreetingsRepository extends JpaRepository<Greetings, Integer> {

    // Findby query to find greetings by message
    // The method name 'findByMessage' is parsed by Spring Data JPA to generate the query
    // to find Greetings entities where the 'message' field matches the provided parameter.
    public List<Greetings> findByMessageContains(String message);

    // Custom query to search greetings by a substring in the message
    @Query("SELECT g FROM Greetings g WHERE g.message LIKE %:query%")
    public List<Greetings> searchMessages(String query);
}
