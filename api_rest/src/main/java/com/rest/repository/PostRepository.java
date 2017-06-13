package com.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
