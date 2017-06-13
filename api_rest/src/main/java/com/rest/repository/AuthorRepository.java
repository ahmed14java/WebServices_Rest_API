package com.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
