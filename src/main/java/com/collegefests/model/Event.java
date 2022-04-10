package com.collegefests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "event")
@NoArgsConstructor
@Getter
@Setter
public class Event implements Serializable {
    @Id
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String eventOrganiser;
    private String phone;
    private String date;
    private String time;
    private String fees;
}
