package project1.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    private List<Person> list;

    public Persons(){
        list = new ArrayList<Person>();
    }

    public void add(Person p){
        list.add(p);
    }
}
