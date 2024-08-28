package app;

import app.daos.PersonDAO;
import app.daos.StudentDAO;
import app.entities.Person;

import app.entities.Person;
import app.entities.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        /*studentDAO.create(
                Student.builder()
                        .name("John")
                        .number(84848484)
                        .email("john@mail.dk")
                        .address("adadw")
                        .birthdate(LocalDate.of(2001,04,29))
                        .build()
        );*/
        studentDAO.update(
                Student.builder()
                        .id(1)
                        .name("Ali")
                        .number(20202020)
                        .email("ali@emial.dk")
                        .address("valby langgade 20")
                        .birthdate(LocalDate.of(2001,01,01))
                        .build()
        );

        studentDAO.getAll().forEach(System.out::println);

        /*
        //Delete person
        studentDAO.delete(
                Student.builder()
                        .id(Integer.valueOf(1))
                        .build()
        );


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
        ); */
    }
}