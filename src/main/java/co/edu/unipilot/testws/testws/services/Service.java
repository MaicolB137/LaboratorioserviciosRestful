/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipilot.testws.testws.services;

import co.edu.unipilot.testws.testws.entidad.Person;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Michael
 */
@Path("services")
public class Service {

    private static Map<Integer, Person> persons = new HashMap();
    private static NumberFormat formatoSalario = NumberFormat.getNumberInstance(new Locale("es", "CO"));

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullname("Apreciado Amigo " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalary();
            persons.put(id, person);
        }
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        persons.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getAverageSalary")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalary() {
        double totalSalary = 0;
        int totalPersons = persons.size();
        for (Person person : persons.values()) {
            totalSalary += person.getSalary();
        }
        double averageSalary = totalSalary / totalPersons;

        String formaAverageSalary = formatoSalario.format(averageSalary);

        return "<averageSalary>" + formaAverageSalary + "</averageSalary>";
    }

    @GET
    @Path("/getTotalSalary")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTotalSalary() {
        double totalSalary = 0;
        for (Person person : persons.values()) {
            totalSalary += person.getSalary();
        }
        String formaTotalSalary = formatoSalario.format(totalSalary);

        return "<TotalSalario>" + formaTotalSalary + "</TotalSalario>";
    }
}
