package ru.itanton.bookservice.in.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itanton.bookservice.model.db.Book;
import ru.itanton.bookservice.service.BookService;


/**
 * @author itanton
 */
@RestController
@RequestMapping("/api/v1/books")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookAPI {

    BookService bookService;

    @GetMapping("{id}")
    public Book getById(@PathVariable int id) {
        log.info("Incoming request. Get by id {}", id);
        return bookService.getById(id);
    }

}
