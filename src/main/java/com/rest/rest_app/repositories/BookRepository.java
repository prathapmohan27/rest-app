package com.rest.rest_app.repositories;

import com.rest.rest_app.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
