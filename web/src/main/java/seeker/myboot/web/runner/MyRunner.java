package seeker.myboot.web.runner;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import seeker.myboot.web.property.SeekerProperties;

@Component
@Order(2)
public class MyRunner implements ApplicationRunner{
	@Value("${seeker.name}")
	String name;
	
	@Autowired
	private SeekerProperties property;
	
	@Autowired
	private String hello;
	
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("=====>>>> start Info Mode에서만 출력됩니다." + property.getName());
		logger.debug("Logger 클래스 이름:" + logger.getClass().getName());
		logger.debug("name : " + hello);
		logger.debug("seeker.age : " + property.getAge());
		logger.debug("seeker.fullname : " + property.getFullName());
		logger.info("=====>>>> end Info Mode에서만 출력됩니다.");
		
	}
}
