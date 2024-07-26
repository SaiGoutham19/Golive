package com.example.golive.Service;
import org.springframework.stereotype.Service;
@Service
public class ZoomService {
    public String createZoomMeeting() {
        // Here you would add logic to interact with Zoom API
        // For the purpose of this example, we're returning a dummy link
        return "https://zoom.us/j/dummy-meeting-link";
    }

    public String createZoomMeeting(String name, String string) {
        return null;
    }
}
