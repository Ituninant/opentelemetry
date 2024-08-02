package ru.itanton.bookservice.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itanton.bookservice.model.db.Book;

/**
 * @author itanton
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}