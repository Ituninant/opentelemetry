package ru.itanton.apigateway.in.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author itanton
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommonAPI {

    RestTemplate restTemplate;

    @GetMapping("hello")
    public String getHello() {
        log.info("hello");
        return "Hello, World!";
    }

    @GetMapping("book/{id}")
    public String getBook(@PathVariable int id) {
        log.info("book");
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/api/v1/books/" + id, String.class);
        return response.getBody();
    }

}
