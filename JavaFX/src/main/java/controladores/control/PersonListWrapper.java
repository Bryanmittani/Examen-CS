package controladores.control;

import modelo.Person;

import java.util.List;



/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 *
 * @author Marco Jakob
 */

public class PersonListWrapper {

    private List<Person> persons;


    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}