package com.caramel.apple.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentJPAResource {

	@Autowired
	private CommentRepository comRepo;
	
	@PostMapping("/create")
		public Comments createComment(@RequestBody Comments comment){
		Comments newcomment = comRepo.save(comment);
	return newcomment;
	}
	
	@GetMapping
	public List<Comments> retrieveAllComments(){
		return comRepo.findAll();
	}
	@DeleteMapping("/delete/id/{id}")
	public void createComment(@RequestParam Long id) {
		comRepo.deleteById(id);
		
	}
	
}
