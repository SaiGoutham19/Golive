package com.example.golive.Service;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

@Service
public class GoogleMeetService {
    public String createGoogleMeetLink() {
        // Here you would add logic to interact with Google Meet API
        // For the purpose of this example, we're returning a dummy link
        return "https://meet.google.com/dummy-meeting-link";
    }
}
