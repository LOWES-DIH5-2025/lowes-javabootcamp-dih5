package com.labs.sboot.service;

import com.labs.sboot.repository.GreetingsRepository;
import com.labs.sboot.exception.NoGreetingsFoundException;
import com.labs.sboot.model.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class GreetingService {
//    private Map<Integer, Greetings> greetings = new HashMap<>();
    @Autowired
GreetingsRepository greetingsRepo;

    public boolean createGreeting(Greetings greeting) {
//        greetings.put(greeting.getId(), greeting);
        greetingsRepo.save(greeting); // Save greeting to the repository
        return true; // Greeting added successfully
    }

    public Greetings getGreeting(int id) throws NoGreetingsFoundException {
        if(!greetingsRepo.existsById(id)) {
            throw new NoGreetingsFoundException("No greeting found with id: " + id);
        }
//        return greetings.get(id); // Returns null if not found
        return greetingsRepo.findById(id).get();
    }

    public Collection<Greetings> getAllGreetings() {
//        return greetings.values(); // Returns all greetings
        return new ArrayList<>(greetingsRepo.findAll()); // Fetch all greetings from the repository
    }

    public boolean updateGreeting(Greetings greeting) throws NoGreetingsFoundException {
        if(!greetingsRepo.existsById(greeting.getId())) {
            throw new NoGreetingsFoundException("No greeting found with id: " + greeting.getId());
        }

//        greetings.put(greeting.getId(), greeting);
//      Update existing greeting
        greetingsRepo.save(greeting); // Save updated greeting to the repository
        return true; // Update successful
    }

    public boolean deleteGreeting(int id) throws NoGreetingsFoundException {
        if(!greetingsRepo.existsById(id)) {
            throw new NoGreetingsFoundException("No greeting found with id: " + id);
        }

//        greetings.remove(id); // Remove greeting by id
        try {
            greetingsRepo.deleteById(id);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());// Delete greeting from the repository
        }
        return true; // Deletion successful
    }

    public Collection<Greetings> searchGreetings(String query) {
        // Implement a simple search by message
//        return greetingsRepo.findAll()
//                .stream()
//                .filter(g -> g.getMessage().toLowerCase().contains(query.toLowerCase()))
//                .toList();
        return greetingsRepo.searchMessages(query);
    }

}
