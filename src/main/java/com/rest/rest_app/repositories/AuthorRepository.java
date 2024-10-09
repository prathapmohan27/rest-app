package com.rest.rest_app.repositories;

import com.rest.rest_app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
