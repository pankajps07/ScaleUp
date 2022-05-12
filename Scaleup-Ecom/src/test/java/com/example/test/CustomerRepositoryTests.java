package com.example.test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;



import com.example.model.Customer;



import com.example.repo.CustomerRepository;




@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {



@Autowired
private TestEntityManager entityManager;

@Autowired
private CustomerRepository repo;
@Test
public void testCreateCustomer() {
Customer cust = new Customer();
cust.setId(01);
cust.setName("upasana");
cust.setMno("981191862014");
cust.setAddress("Bengaluru");
cust.setEmail("uppu@gmail.com");
cust.setPassword("1234");


Customer savedCust = repo.save(cust);

Customer existUser = entityManager.find(Customer.class, savedCust.getId());

assertThat(cust.getEmail()).isEqualTo(existUser.getEmail());

}



}