package com.caramel.apple.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://benjaminjbonnet01.s3-website-us-east-1.amazonaws.com")
public class PostJPAResource {

	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
public List<Post> createPost(){
	return postRepository.findAll();
		
	}
	@PostMapping("/posts/create")
	public Post createPost( @RequestBody Post post) {
		
		Post savedPost = postRepository.save(post);
		return savedPost;
	}
	
	@DeleteMapping("/posts/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		 postRepository.deleteById(id);
		
		
	}

	
}
