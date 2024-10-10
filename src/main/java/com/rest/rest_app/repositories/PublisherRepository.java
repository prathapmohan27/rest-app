package com.rest.rest_app.repositories;

import com.rest.rest_app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
