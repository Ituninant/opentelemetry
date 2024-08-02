package ru.itanton.bookservice.service;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itanton.bookservice.model.db.Book;
import ru.itanton.bookservice.out.db.BookRepository;

/**
 * @author itanton
 */
@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {

    BookRepository bookRepository;

    @PostConstruct
    public void init() {
        bookRepository.save(Book.builder().name("test1").build());
        bookRepository.save(Book.builder().name("test2").build());
        bookRepository.save(Book.builder().name("test3").build());
    }

    @WithSpan("BookService.getById()")
    public Book getById(@SpanAttribute int id) {
        log.info("Search book by id {}", id);
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));
    }
}
