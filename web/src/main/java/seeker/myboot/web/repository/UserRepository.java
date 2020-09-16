package seeker.myboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import seeker.myboot.web.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
