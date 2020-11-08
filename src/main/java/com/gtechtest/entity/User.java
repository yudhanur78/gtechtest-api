package com.gtechtest.entity;

import com.gtechtest.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "GT_MST_USER")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER", nullable = false)
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "PASSWORD")
    private String password;
}
