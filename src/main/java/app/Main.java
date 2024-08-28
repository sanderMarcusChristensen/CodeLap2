package app;

import app.daos.PersonDAO;
import app.entities.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        personDAO.create(
                Person.builder()
                        .name("John")
                        .age(30)
                        .build()
        );
        personDAO.getAll().forEach(System.out::println);

        //Delete person
        personDAO.delete(
                Person.builder()
                        .id(Integer.valueOf(1))
                        .build()
        );
    }
}