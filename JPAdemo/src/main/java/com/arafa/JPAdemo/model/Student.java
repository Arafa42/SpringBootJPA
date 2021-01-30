package com.arafa.JPAdemo.model;

import javax.persistence.*;

@Entity(name = "com.arafa.JPAdemo.JpAdemoApplication.Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name="student_email_unique",columnNames = "email")
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="firstname",
            //nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name="lastname",
            //nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name="email",
            columnDefinition = "TEXT"
            //unique = true
    )
    private String email;
    @Column(
            name="age",
            nullable = false
    )
    private Integer age;




    public Student(String firstName, String lastName, String email, Integer age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "com.arafa.JPAdemo.JpAdemoApplication.Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }


    public Student(){}


}
