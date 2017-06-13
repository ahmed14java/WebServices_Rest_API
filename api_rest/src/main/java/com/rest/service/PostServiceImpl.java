package com.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.Post;
import com.rest.repository.AuthorRepository;
import com.rest.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Iterable<Post> list() {
		return postRepository.findAll();
	}

	@Override
	@Transactional
	public Post create(Post post) {
		authorRepository.save(post.getAuthor());
		return postRepository.save(post);
	}

	@Override
	public Post read(long id) {
		return postRepository.findOne(id);
	}

	@Override
	public Post update(long id, Post update) {
		Post post = postRepository.findOne(id);
		if (update.getTitle() != null) {
			post.setTitle(update.getTitle());
		}
		return postRepository.save(post);
	}

	@Override
	public void delete(long id) {
		postRepository.delete(id);
	}

}
