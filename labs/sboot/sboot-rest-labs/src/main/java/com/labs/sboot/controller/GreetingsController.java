package com.labs.sboot.controller;

import com.labs.sboot.service.GreetingService;
import com.labs.sboot.exception.NoGreetingsFoundException;
import com.labs.sboot.config.GreetingsConfig;
import com.labs.sboot.model.Greetings;
import com.labs.sboot.model.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController()
@Slf4j
@Tag(name = "Greetings API", description = "Handles greetings operations")
public class GreetingsController {

//    private static final Logger logger = LoggerFactory.getLogger(GreetingsController.class);

    @Autowired
    GreetingService greetingService;

    @Autowired
    GreetingsConfig greetingsConfig;

//    @GetMapping(path = "/")
    @Operation(summary = "Get Greetings", description = "Returns a greeting message with ID and content")
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String greetings() {
//        Greetings greetings = new Greetings(123,"Hello");
//        Greetings greetings = Greetings.builder().id(greetingsConfig.getId())
//                .message(greetingsConfig.getMessage()).build();
//        log.info(greetings.toString());
//        return greetings;
        return "Greetings from Spring Boot REST API!";
    }

//    @GetMapping(path = "/greetings", produces = "application/json")
//    // Nouns - URI: /greetings
//    // Verbs - HTTP Methods: GET
//    // Content Type: application/json
//    public Greetings greetingMsg() {
////        return new Greetings("Hello from Spring Boot REST!!");
//        return new Greetings();
//    }

    @Operation(summary = "Create Greeting", description = "Creates a new greeting message")
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

    @Operation(summary = "Get All Greetings", description = "Retrieves all greeting messages")
    @GetMapping(path = "/greetings", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Greetings>> getAllGreetings() throws NoGreetingsFoundException {
        Collection<Greetings> greetingsList = greetingService.getAllGreetings();
        greetingsList.forEach(greeting -> {
            Link selfLink = null;
            try {
                selfLink = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(GreetingsController.class).getGreeting(greeting.getId())
                ).withSelfRel();
            } catch (NoGreetingsFoundException e) {
                log.error("Error: " + e.getMessage(), e);
            }
            greeting.add(selfLink);
        });
        return ResponseEntity.ok(greetingsList);
    }

    @Operation(summary = "Get Greeting by ID", description = "Retrieves a greeting message by its ID")
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

        // HATEOAS Support
        // Add self-link
        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(GreetingsController.class).getGreeting(id)
        ).withSelfRel();

        greeting.add(selfLink);

        return ResponseEntity.ok(greeting);
    }

    @Operation(summary = "Update Greeting", description = "Updates an existing greeting message")
    @PutMapping(path = "/greetings/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<ResponseMessage> updateGreeting(@PathVariable int id, @RequestBody @Valid Greetings greetings) throws NoGreetingsFoundException {
//        greetings.setId(id);

        boolean status = greetingService.updateGreeting(greetings);
        String msg = status ? "Greeting updated successfully!" : "Greeting update failed!";
        log.info(msg);
        ResponseMessage responseMessage = new ResponseMessage("SUCCESS", msg);
        return ResponseEntity.ok(responseMessage);
    }

    @Operation(summary = "Delete Greeting", description = "Deletes a greeting message by its ID")
    @DeleteMapping(path = "/greetings/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<ResponseMessage> deleteGreeting(@PathVariable int id) throws NoGreetingsFoundException {
        boolean status = greetingService.deleteGreeting(id);
        String msg = status ? "Greeting deleted successfully!" : "Greeting deletion failed!";
        log.info(msg);
        ResponseMessage responseMessage = new ResponseMessage("SUCCESS", msg);
        return ResponseEntity.ok(responseMessage);
    }

    @Operation(summary = "Search Greetings", description = "Searches for greeting messages based on a query")
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
