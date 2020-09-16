package seeker.myboot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seeker.myboot.web.entity.User;
import seeker.myboot.web.exception.ResourceNotFoundException;
import seeker.myboot.web.repository.UserRepository;

@RestController
public class RESTUserController {
	private final UserRepository repository;

	public RESTUserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/users")
	public User insert(@RequestBody User addUser) {
		return repository.save(addUser);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> optional = repository.findById(id);
		User user = optional.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		//값을 변경
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		//DB에 save()
		User updatedUser = repository.save(user);
		return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		Optional<User> optional = repository.findById(id);
		//요청한 id와 매핑하는 User가 없는 경우
		if(optional.isEmpty()) {
			return new ResponseEntity<>("요청한 User가 없습니다.", HttpStatus.NOT_FOUND);
		}
		//DB에서 삭제 
		repository.deleteById(id);
		return new ResponseEntity<>(id + "번 User가 삭제됨", HttpStatus.OK);
	}
}
