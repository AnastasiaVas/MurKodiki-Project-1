package project1.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement
public class Person {
    long id;
    String fname;
    String lname;
    int age;
    String city;

    public Person(){

    }

    public Person(long id, String fname, String lname, int age, String city) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.city = city;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @XmlElement
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                fname.equals(person.fname) &&
                lname.equals(person.lname) &&
                city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, age, city);
    }
}
