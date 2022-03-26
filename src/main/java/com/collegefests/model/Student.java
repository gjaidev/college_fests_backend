package com.collegefests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    @Id
    private Long id;
    private String name;
    private String number;
    private int age;
}
