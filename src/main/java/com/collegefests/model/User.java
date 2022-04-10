package com.collegefests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;
    private String role;
}
