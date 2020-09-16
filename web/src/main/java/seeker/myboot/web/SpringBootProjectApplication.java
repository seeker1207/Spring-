package seeker.myboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootProjectApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootProjectApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}

}
