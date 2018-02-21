package com.spring.data.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.spring.data.practice.entity.Address;
import com.spring.data.practice.entity.Person;

@SpringBootApplication
public class SpringBootHibernate5SecurityClientApplication {

	private static RestTemplate restTemplate = new RestTemplate();

	private static String resourceBaseURI = "http://localhost:9091/savePerson";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernate5SecurityClientApplication.class, args);
		Person person = new Person();
		person.setfName("YENDURI");
		person.setlName("SAI KRISHNA");
		person.setMobileNo("9396519139");

		List<Address> addresses = new ArrayList<Address>();
		Address address1 = new Address();
		address1.setAddrLine1("QWERTY");
		address1.setAddrLine2("ABCDEFG");
		address1.setCity("HYD");
		address1.setState("HYD");
		address1.setCountry("IND");
		address1.setZipCode(600096);

		addresses.add(address1);

		person.setAddress(addresses);

		String responseStatus = restTemplate.postForObject(resourceBaseURI, person, String.class);
		
		System.out.println("Status ============> "+responseStatus);

	}

}
