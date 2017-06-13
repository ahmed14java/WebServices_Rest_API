package com.rest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Post;
import com.rest.exception.PostNotFoundException;
import com.rest.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Post> posts() {
		Iterable<Post> posts = postService.list();
		return posts;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Post create(@RequestBody Post post) {
		return postService.create(post);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Post read(@PathVariable(value = "id") long id) throws PostNotFoundException {
		Post post = postService.read(id);
		if (post == null) {
			throw new PostNotFoundException("post with id " + id + "not found");
		}

		return post;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Post update(@PathVariable(value = "id") long id, @RequestBody Post post) {
		return postService.update(id, post);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
		postService.delete(id);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
