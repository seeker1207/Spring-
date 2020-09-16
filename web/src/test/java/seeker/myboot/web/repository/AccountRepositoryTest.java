package seeker.myboot.web.repository;

import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import seeker.myboot.web.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	private AccountRepository repository;
	
	@Test @Ignore
	public void update() {
		Optional<Account> findById = repository.findById(2l);
		if(findById.isPresent()) {
			Account account = findById.get();
			account.setEmail("dooly@aa.com");
			repository.save(account);
		}
	}
	@Test
	public void finder() {
		Account account = repository.findByUsername("lambda2");
		System.out.println(account);
		
		Optional<Account> optional = repository.findById(100L);
		System.out.println(optional.isPresent());
		if(optional.isPresent()) {
			Account account2 = optional.get();
			System.out.println(account2);	
		}
		
//		//요청 ID가 있으면 Account 객체를 반환하고, 없으면 예외를 발생시켜봅니다.
//		Optional<Account> optEmail = repository.findByEmail("dooly@aa.com");
//		//Suppler 의 T get()
//		Account account3 = optEmail.orElseThrow(() -> new RuntimeException("요청한 Email주소를 가진 Account가 없음!"));
//		System.out.println(account3);
		
		List<Account> accountList = repository.findAll();
		accountList.forEach(acct -> System.out.println(acct));
		accountList.forEach(System.out::println);
	}
	@Test @Ignore
	public void account() throws Exception{
		//1. Account 객체 생성 -> 등록
		Account account = new Account();
		account.setUsername("lambda");
		account.setPassword("1234");
		account.setEmail("dooly@aa.com");
		
		Account addAccount = repository.save(account);
		System.out.println(addAccount.getId());
		
	}
}
