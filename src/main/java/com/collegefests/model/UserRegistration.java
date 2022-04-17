package com.collegefests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userRegistration")
@NoArgsConstructor
@Getter
@Setter
public class UserRegistration implements Serializable {
    @Id
    private int registrationId;
    private int eventId;
    private int userId;
    private String eventName;
    private String phone;
    private String email;
}
