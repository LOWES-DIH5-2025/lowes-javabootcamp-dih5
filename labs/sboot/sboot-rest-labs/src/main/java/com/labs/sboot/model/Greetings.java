package com.labs.sboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Component
//@Setter
//@Getter
//@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@RequiredArgsConstructor
//public class Greetings {
// HATEOAS Support
public class Greetings extends RepresentationModel<Greetings> {
    @Positive(message = "ID must be a positive number")
//    @Size(min = 1, max = 100, message = "ID must be between 1 and 100")
//    @Value("100")
    @Id
    private int id;

    @NotBlank(message = "Message cannot be blank")
    @NotNull(message = "Message cannot be null")
//    @Value("Testing")
    private String message;

//    public Greetings() {
//    }
//
//    public Greetings(String message) {
//        this.message = message;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }

}
