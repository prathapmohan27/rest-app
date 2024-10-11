package com.rest.rest_app.services;

import com.rest.rest_app.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
