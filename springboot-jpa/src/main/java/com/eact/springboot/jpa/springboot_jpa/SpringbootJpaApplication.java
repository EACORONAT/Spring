package com.eact.springboot.jpa.springboot_jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.eact.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.eact.springboot.jpa.springboot_jpa.entities.Person;
import com.eact.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//list();
		//findOne();
		//create();
		update();
		//delete();
		//deletet();
		//consultP1();
		//consultP2();
		//consultP3();
		//consultP4();
		//consultP5();
		//consultP6();
		//consultP7();
		//consultP8();
	}

	// Por valores:
	public void list(){
		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>) repository.findByNombre("Eduardo");
		List<Person> persons = (List<Person>) repository.findByNombreAndApellido("Eduardo", "Corona");

		persons.stream().forEach(person -> System.out.println(person));

		List<Object[]> personV = repository.obtenerPersonas();
		personV.stream().forEach(person -> System.out.println("Su nombre es " + person[0] + " y su apellido " + person[1]));
	}

	// Por ID:
	@Transactional(readOnly = true)
	public void findOne(){
		/* Person person = null;
		Optional<Person> optionalp = repository.findById(1L);
		if(optionalp.isPresent()){
			person = optionalp.get();
		}
		System.out.println(person); */
		repository.findOneCoinNombre("Ed").ifPresent(System.out::println);
	}

	@Transactional
	public void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre:");
		System.out.print("- ");
		String nombre = scanner.next();
		System.out.println("Ingrese el apellido:");
		System.out.print("- ");
		String apellido = scanner.next();
		System.out.println("Ingrese el lenguaje de programacion:");
		System.out.print("- ");
		String lenguajeProg = scanner.next();
		scanner.close();

		Person person = new Person(null, nombre, apellido, lenguajeProg);
		Person personNew = repository.save(person);

		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(p -> System.out.println(p));
	}

	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona:");
		System.out.print("- ");
		Long id = scanner.nextLong();
		
		Optional<Person> optPerson = repository.findById(id);
		optPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programacion:");
			String lenguajeProg = scanner.next();
			person.setLenguajeprog(lenguajeProg);
			Person personDB = repository.save(person);
			System.out.println(personDB);
		});		
		scanner.close();
	}

	@Transactional
	public void delete(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a eliminar:");
		System.out.print("- ");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		
		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void deletet(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a eliminar:");
		System.out.print("- ");
		Long id = scanner.nextLong();

		Optional<Person> optperson = repository.findById(id);

		optperson.ifPresentOrElse(person -> repository.delete(person), () -> System.out.println("No existe la persona con ese id"));		
		
		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void consultP1(){		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a consultar:");
		System.out.print("- ");
		Long id = scanner.nextLong();

		String nombreCom = repository.getNombreComplById(id);
		System.out.println(nombreCom);

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void consultP2(){				
		System.out.println("Consulta DTO:");
		List<PersonDto> personsDto = repository.obtenerDatosPersonasDto();
		personsDto.forEach(System.out::println);			
	}

	@Transactional(readOnly = true)
	public void consultP3(){				
		System.out.println("Consulta Distinc");
		System.out.println("Cuenta solo los valores unicos:");
		List<String> lenguajeProg = repository.obtenerLPDistinc();
		lenguajeProg.forEach(System.out::println);			
		System.out.println("Consulta Count Distinc");
		System.out.println("Cuenta el total:");
		Long totalenguajeProg = repository.obtenerLPCountDistinc();
		System.out.println("Total: " + totalenguajeProg);			
	}

	@Transactional(readOnly = true)
	public void consultP4(){			
		List<String> nombres = repository.obtenerNombrell();	
		System.out.println("Consulta Upper");
		System.out.println("Nombres y Apellidos en mayuscula");
		nombres = repository.obtenerNombreUpper();
		nombres.forEach(System.out::println);
				
		System.out.println("Consulta Count Lower");
		System.out.println("Nombres y Apellidos en minuscula");
								
		nombres = repository.obtenerNombreLower();
		nombres.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void consultP5() {
        System.out.println("Consulta Between Asc");
        System.out.println("Orden ascendente:");
        List<Person> persons = repository.ordenarAsc();
        persons.forEach(System.out::println);

        System.out.println("Consulta Between Desc");
        System.out.println("Orden descendente:");
        persons = repository.ordenarDesc();
        persons.forEach(System.out::println);
    }

	@Transactional(readOnly = true)
	public void consultP6() {
        System.out.println("Consulta Where In");		
		List<Person> persons = repository.getPersonsByIds(Arrays.asList(1L, 2L, 5L, 7L));
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void consultP7() {
        System.out.println("Consulta Length");		
		System.out.println("Nombre mas corto y su largo");
		List<Object[]> registers = repository.getShorterName();
		registers.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name=" + name + ", length=" + length);	
		});

		System.out.println("Ultimo registro de persona:");
		Optional<Person> optionalPerson = repository.getLastRegistration();
		optionalPerson.ifPresent(System.out::println);
	}
	
	@Transactional(readOnly = true)
	public void consultP8() {		
		System.out.println("Total de registros de la tabla persona:");
		Long count = repository.getTotalPerson();
		System.out.println(count);
		
		System.out.println("Valor minimo del id:");
		Long min = repository.getMinId();
		System.out.println(min);
		
		System.out.println("Valor maximo del id:");
		Long max = repository.getMaxId();
		System.out.println(max);
		
		System.out.println("Nombre y su largo:");
		List<Object[]> regs = repository.getPersonNameLength();
		regs.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name=" + name + ", length=" + length);
		});
		
		System.out.println("Nombre mas corto:");
		Integer minLengthName = repository.getMinLengthName();
		System.out.println(minLengthName);
		
		System.out.println("Nombre mas largo:");
		Integer maxLengthName = repository.getMaxLengthName();
		System.out.println(maxLengthName);

		System.out.println("Resumen de funciones de agregacion min, max, sum, avg, count:");
		Object[] resumeReg = (Object[]) repository.getResumeAggregationFunction();
		System.out.println(
			    "min=" + resumeReg[0] +
				", max=" + resumeReg[1] +
				", sum=" + resumeReg[2] +
				", avg=" + resumeReg[3] +
		        ", count=" + resumeReg[4]);
	}
}