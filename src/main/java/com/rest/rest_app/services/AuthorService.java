package com.rest.rest_app.services;

import com.rest.rest_app.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
