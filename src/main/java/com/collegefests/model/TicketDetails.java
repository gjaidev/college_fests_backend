package com.collegefests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TicketDetails implements Serializable {
    private String userName;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String date;
    private String time;
}
