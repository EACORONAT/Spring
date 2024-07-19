package com.eact.springboot.jpa.rs.springboot_jpa_relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Address;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Client;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.ClientDetails;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Course;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Invoice;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Student;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories.ClientDetailsRepository;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories.ClientRepository;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories.InvoiceRepository;
import com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories.StudentRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private ClientDetailsRepository detailsRepo;

	@Autowired
	private StudentRepository studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//manyToOne();
		//manyToOneFindById();
		//oneToMany();
		//oneToManyFindById();
		//removeAddress();
		//removeAddressFindById();
		//oneToManyBidirectional();
		//oneToManyBidirectionalFindById();
		//removeBidirectionalFindById();
		//oneToOne();
		//oneToOneBidirectional();
		//manyToMany();
		manyToManyBidirectional();
	}

	@Transactional
	public void manyToOne(){
		Client client = new Client("Jose", "Martinez");
		clientRepo.save(client);

		Invoice invoice = new Invoice("Calzado Adidas", 1500L);
		invoice.setClient(client);

		Invoice invoiceDB = invoiceRepo.save(invoice);
		System.out.println("Factura:");
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindById(){
		Optional<Client> optionalCli = clientRepo.findById(1L);
		if (optionalCli.isPresent()) {
			Client client = optionalCli.orElseThrow();
		
			Invoice invoice = new Invoice("Calzado Adidas", 1500L);
			invoice.setClient(client);
			Invoice invoiceDB = invoiceRepo.save(invoice);
			System.out.println("Factura:");
			System.out.println(invoiceDB);
		}
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Alberto", "Trujillo");

		Address addressOne = new Address("La Paz", 215);
		Address addressTwo = new Address("La Luz", 418);

		client.getAddresses().add(addressOne);
		client.getAddresses().add(addressTwo);

		clientRepo.save(client);

		System.out.println(client);
	}

	@Transactional
	public void oneToManyFindById() {
		Optional<Client> optionalCli = clientRepo.findById(1L);
		optionalCli.ifPresent(client -> {            
			Address addressOne = new Address("Arnica", 215);
			Address addressTwo = new Address("La Luz", 418);
	
			List<Address> addresses = new ArrayList<>();
			addresses.add(addressOne);
			addresses.add(addressTwo);
	
			client.setAddresses(addresses);
	
			clientRepo.save(client);
	
			System.out.println(client);
		});
	}
	
	@Transactional
	public void removeAddress(){
		Client client = new Client("Alberto", "Trujillo");

		Address addressOne = new Address("La Paz", 215);
		Address addressTwo = new Address("La Luz", 418);

		client.getAddresses().add(addressOne);
		client.getAddresses().add(addressTwo);

		clientRepo.save(client);

		System.out.println(client);

		Optional<Client> optionalClient = clientRepo.findById(3L);
		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(addressOne);
			clientRepo.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void removeAddressFindById() {
		Optional<Client> optionalCli = clientRepo.findById(2L);
		optionalCli.ifPresent(client -> {            
			Address addressOne = new Address("Arnica", 215);
			Address addressTwo = new Address("La Luz", 418);
	
			List<Address> addresses = new ArrayList<>();
			addresses.add(addressOne);
			addresses.add(addressTwo);
	
			client.setAddresses(addresses);
	
			clientRepo.save(client);
	
			System.out.println(client);

			optionalCli.ifPresent(c -> {
				c.getAddresses().remove(addressOne);
				clientRepo.save(c);
				System.out.println(c);
			});
		});
	}

	@Transactional
	public void oneToManyBidirectional(){
		Client client = new Client("Alberto", "Trujillo");

		Invoice invoiceOne = new Invoice("Calzado Puma", 1000L);
		Invoice invoiceTwo = new Invoice("Calzado Nike", 1100L);

		List<Invoice> invoices = new ArrayList<>();
		invoices.add(invoiceOne);
		invoices.add(invoiceTwo);
		client.setInvoices(invoices);

		invoiceOne.setClient(client);
		invoiceTwo.setClient(client);

		clientRepo.save(client);

		System.out.println(client);
	}

	@Transactional
	public void oneToManyBidirectionalFindById(){
		Optional<Client> optClient = clientRepo.findById(1L);
		optClient.ifPresent(client -> {			
			Invoice invoiceOne = new Invoice("Calzado Puma", 1000L);
			Invoice invoiceTwo = new Invoice("Calzado Nike", 1100L);
	
			List<Invoice> invoices = new ArrayList<>();
			invoices.add(invoiceOne);
			invoices.add(invoiceTwo);
			client.setInvoices(invoices);
	
			invoiceOne.setClient(client);
			invoiceTwo.setClient(client);
	
			clientRepo.save(client);
			System.out.println(client);
		});
	}

	@Transactional
	public void removeBidirectionalFindById(){
		Optional<Client> optClient = clientRepo.findById(1L);
		optClient.ifPresent(client -> {			
			Invoice invoiceOne = new Invoice("Calzado Puma", 1000L);
			Invoice invoiceTwo = new Invoice("Calzado Nike", 1100L);
	
			List<Invoice> invoices = new ArrayList<>();
			invoices.add(invoiceOne);
			invoices.add(invoiceTwo);
			client.setInvoices(invoices);
	
			invoiceOne.setClient(client);
			invoiceTwo.setClient(client);
	
			clientRepo.save(client);
			System.out.println(client);
		});
		
		Optional<Client> optClientBD = clientRepo.findById(1L);
		optClientBD.ifPresent(client -> {
			Optional<Invoice> opyInvoice = invoiceRepo.findById(2L);
			opyInvoice.ifPresent(invoice -> {
				client.getInvoices().remove(invoice);
				invoice.setClient(null);
				clientRepo.save(client);
				System.out.println(client);
			});
		});
	}

	@Transactional
	public void oneToOne(){
		Client client = new Client("Jose", "Perez");
		clientRepo.save(client);

		ClientDetails clientDeta = new ClientDetails(true, 5000);
		clientDeta.setClient(client);
		detailsRepo.save(clientDeta);				
	}

	@Transactional
	public void oneToOneBidirectional(){
		Client client = new Client("David", "Cano");
		ClientDetails clientDetails = new ClientDetails(true, 5000);

		client.setClientDetails(clientDetails);
		clientDetails.setClient(client);

		clientRepo.save(client);
		detailsRepo.save(clientDetails);    
	}

	@Transactional
	public void manyToMany(){
		Student studentOne = new Student("Alejandro", "Corona");
		Student studentTwo = new Student("Juan", "Hernandez");

		Course courseOne = new Course("Español", "Fernando Gomez");
		Course courseTwo = new Course("Logica", "Carla Salazar ");

		studentOne.setCourses(Set.of(courseOne, courseTwo));
		studentTwo.setCourses(Set.of(courseTwo));

		studentRepo.saveAll(List.of(studentOne, studentTwo));

		System.out.println(studentOne);
		System.out.println(studentTwo);
	}

	@Transactional
	public void manyToManyBidirectional(){
		Student studentOne = new Student("Alejandro", "Corona");
		Student studentTwo = new Student("Juan", "Hernandez");

		Course courseOne = new Course("Español", "Fernando Gomez");
		Course courseTwo = new Course("Logica", "Carla Salazar ");
		
		studentOne.addCourse(courseOne);
		studentOne.addCourse(courseTwo);
		studentTwo.addCourse(courseTwo);

		studentRepo.saveAll(List.of(studentOne, studentTwo));

		System.out.println(studentOne);
		System.out.println(studentTwo);
	}
}
