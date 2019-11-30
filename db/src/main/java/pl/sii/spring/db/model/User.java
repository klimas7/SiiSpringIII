package pl.sii.spring.db.model;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
public class User {
    public User() {
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "firstName")
    private String firstName;

//    @Column(name = "lastName")
    private String lastName;

//    @Column(name = "age")
    private Integer userAge;

//    @Column(name = "birthDate")
    private LocalDateTime birthDate;

    public User(Long id, String firstName, String lastName, Integer userAge, LocalDateTime birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAge = userAge;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
