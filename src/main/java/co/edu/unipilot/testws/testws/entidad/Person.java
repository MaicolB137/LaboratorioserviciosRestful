/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipilot.testws.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Michael
 */
@XmlRootElement(name="Person")
@XmlType(propOrder={"id","fullname","age","salary"})
public class Person {
    
    private int id;
    private String fullname;
    private int age;
    private double salary;

    public Person() {
    }

    
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public double getSalary() {
        return salary;
    }

    public void setSalary() {
        this.salary = this.age*1300000/3;
    }
}
