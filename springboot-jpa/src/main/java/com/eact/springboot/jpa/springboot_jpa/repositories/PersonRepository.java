package com.eact.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eact.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.eact.springboot.jpa.springboot_jpa.entities.Person;
import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long>{
    // Consultas personalizadas:
    @Query("select concat (p.nombre, ' ', p.apellido) from Person p where p.id=?1")
    String getNombreComplById(Long id);

    @Query("select new com.eact.springboot.jpa.springboot_jpa.dto.PersonDto(p.nombre, p.apellido) from Person p")
    List<PersonDto> obtenerDatosPersonasDto();

    @Query("select distinct(p.lenguajeProg) from Person p")
    List<String> obtenerLPDistinc();

    @Query("select count(distinct(p.lenguajeProg)) from Person p")
    Long obtenerLPCountDistinc();

    @Query("select upper(concat(p.nombre, ' ', p.apellido)) from Person p")
    List<String> obtenerNombreUpper();

    @Query("select lower(concat(p.nombre, ' ', p.apellido)) from Person p")
    List<String> obtenerNombreLower();

    @Query("select p.nombre || ' ' || p.apellido from Person p")
    List<String> obtenerNombrell();

    @Query("select p from Person p order by p.nombre asc, p.apellido asc")
    List<Person> ordenarAsc();

    @Query("select p from Person p order by p.nombre desc, p.apellido desc")
    List<Person> ordenarDesc();

    // ------------------------------------------------------------------
    @Query("select p from Person p where p.id in ?1")
    public List<Person> getPersonsByIds(List<Long> ids);

    @Query("select p.nombre, length(p.nombre) from Person p where length(p.nombre)=(select min(length(p.nombre)) from Person p)")
    public List<Object[]> getShorterName();

    @Query("select p from Person p where p.id=(select max(p.id) from Person p)")
    public Optional<Person> getLastRegistration();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.nombre)), count(p.id) from Person p")
    public Object getResumeAggregationFunction();
    
    @Query("select min(length(p.nombre)) from Person p")
    public Integer getMinLengthName();
    
    @Query("select max(length(p.nombre)) from Person p")
    public Integer getMaxLengthName();

    @Query("select p.nombre, length(p.nombre) from Person p")
    public List<Object[]> getPersonNameLength();

    @Query("select count(p) from Person p")
    Long getTotalPerson();

    @Query("select min(p.id) from Person p")
    Long getMinId();
    
    @Query("select max(p.id) from Person p")
    Long getMaxId();
    // ------------------------------------------------------------------

    @Query("select p from Person p where p.id=?1")
    Optional <Person> findOne(Long id);
    
    @Query("select p from Person p where p.nombre=?1")
    Optional <Person> findOneNombre(String nombre);
    
    @Query("select p from Person p where p.nombre like %?1%")
    Optional <Person> findOneCoinNombre(String nombre);

    List<Person> findByNombre(String nombre);
    List<Person> findByNombreAndApellido(String nombre, String apellido);
    
    @Query("select p.nombre, p.apellido from Person p")
    List<Object[]> obtenerPersonas();
}