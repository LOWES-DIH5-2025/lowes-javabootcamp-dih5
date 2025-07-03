package com.labs.sboot;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@Slf4j
public class GreetingsController {

//    private static final Logger logger = LoggerFactory.getLogger(GreetingsController.class);

    @Autowired
    GreetingService greetingService;

    @Autowired
    GreetingsConfig greetingsConfig;

//    @GetMapping(path = "/")
    @RequestMapping(path = "/", method = RequestMethod.GET)

    public Greetings greetings() {
//        Greetings greetings = new Greetings(123,"Hello");
        Greetings greetings = Greetings.builder().id(greetingsConfig.getId())
                .message(greetingsConfig.getMessage()).build();
        log.info(greetings.toString());
        return greetings;
    }

//    @GetMapping(path = "/greetings", produces = "application/json")
//    // Nouns - URI: /greetings
//    // Verbs - HTTP Methods: GET
//    // Content Type: application/json
//    public Greetings greetingMsg() {
////        return new Greetings("Hello from Spring Boot REST!!");
//        return new Greetings();
//    }

    @PostMapping(path = "/greetings", consumes = {"application/json", "application/xml"}, produces = {"application/xml", "application/json"})
    public ResponseEntity<ResponseMessage> createGreeting(@RequestBody @Valid Greetings greetings) throws URISyntaxException {
        log.debug("Received request to create greeting: {}", greetings);
        boolean status = greetingService.createGreeting(greetings);
        int id = greetings.getId();

        String msg = status ? "Greeting created successfully!" : "Greeting creation failed!";
//        if(true) {
//            throw new RuntimeException("Simulated Exception for testing");
//        }
       // logger.info(msg);
        ResponseMessage responseMessage = new ResponseMessage("SUCCESS", msg);
        return ResponseEntity.created(new URI("http://localhost:8080/greetings/" + id)).body(responseMessage);
    }

    @GetMapping(path = "/greetings", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Greetings>> getAllGreetings() {
        return ResponseEntity.ok(greetingService.getAllGreetings());
    }

    @GetMapping(path = "/greetings/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Greetings> getGreeting(@PathVariable int id) throws NoGreetingsFoundException {
        Greetings greeting = null;
//        try {
             greeting = greetingService.getGreeting(id);
//        } catch (NoGreetingsFoundException e) {
//            System.out.println("Error: " + e.getMessage());
//            ResponseMessage responseMessage = new ResponseMessage("ERROR", e.getMessage());
//            return ResponseEntity.badRequest().body(responseMessage);
//        }
        return ResponseEntity.ok(greeting);
    }

    @PutMapping(path = "/greetings/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<ResponseMessage> updateGreeting(@PathVariable int id, @RequestBody @Valid Greetings greetings) throws NoGreetingsFoundException {
//        greetings.setId(id);

        boolean status = greetingService.updateGreeting(greetings);
        String msg = status ? "Greeting updated successfully!" : "Greeting update failed!";
        log.info(msg);
        ResponseMessage responseMessage = new ResponseMessage("SUCCESS", msg);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping(path = "/greetings/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<ResponseMessage> deleteGreeting(@PathVariable int id) throws NoGreetingsFoundException {
        boolean status = greetingService.deleteGreeting(id);
        String msg = status ? "Greeting deleted successfully!" : "Greeting deletion failed!";
        log.info(msg);
        ResponseMessage responseMessage = new ResponseMessage("SUCCESS", msg);
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping(path = "/greetings/search", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Greetings>> searchGreetings(@RequestParam(name = "query", required = false, defaultValue = "Hello") String query) {
        return ResponseEntity.ok(greetingService.searchGreetings(query));
    }


    @ExceptionHandler(NoGreetingsFoundException.class)
    public ResponseEntity<ResponseMessage> handleNoGreetingsFoundException(NoGreetingsFoundException e) {
        ResponseMessage responseMessage = new ResponseMessage("ERROR", e.getMessage());
        return ResponseEntity.badRequest().body(responseMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException e) {
//        String errorMessage =
//                e.getBindingResult().getFieldError().getDefaultMessage();
        StringBuilder sb = new StringBuilder();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            sb.append(fieldError.getField())
              .append(": ")
              .append(fieldError.getDefaultMessage())
              .append("; ");
        });
        log.error(sb.toString(), e);
        ResponseMessage responseMessage = new ResponseMessage("ERROR", "Validation failed: " + sb.toString());
        return ResponseEntity.badRequest().body(responseMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleException(Exception e) {
        ResponseMessage responseMessage = new ResponseMessage("ERROR", "CONTROLLER: An unexpected error occurred: " + e.getMessage());
        log.error("An unexpected error occurred: {}", e.getMessage(), e);
        return ResponseEntity.internalServerError().body(responseMessage);
    }

}
