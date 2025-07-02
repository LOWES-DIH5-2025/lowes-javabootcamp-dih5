package com.labs.sboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    private Map<Integer, Greetings> greetings = new HashMap<>();

    public boolean createGreeting(Greetings greeting) {
        greetings.put(greeting.getId(), greeting);
        return true; // Greeting added successfully
    }

    public Greetings getGreeting(int id) throws NoGreetingsFoundException {
        if(!greetings.containsKey(id)) {
            throw new NoGreetingsFoundException("No greeting found with id: " + id);
        }
        return greetings.get(id); // Returns null if not found
    }

    public Collection<Greetings> getAllGreetings() {
        return greetings.values(); // Returns all greetings
    }

    public boolean updateGreeting(Greetings greeting) throws NoGreetingsFoundException {
        if(!greetings.containsKey(greeting.getId())) {
            throw new NoGreetingsFoundException("No greeting found with id: " + greeting.getId());
        }

        greetings.put(greeting.getId(), greeting); // Update existing greeting
        return true; // Update successful
    }

    public boolean deleteGreeting(int id) throws NoGreetingsFoundException {
        if(!greetings.containsKey(id)) {
            throw new NoGreetingsFoundException("No greeting found with id: " + id);
        }

        greetings.remove(id); // Remove greeting by id
        return true; // Deletion successful
    }

    public Collection<Greetings> searchGreetings(String query) {
        // Implement a simple search by message
        return greetings.values()
                .stream()
                .filter(g -> g.getMessage().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }

}
