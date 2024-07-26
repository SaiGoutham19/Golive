package com.example.golive.Service;
import com.example.golive.Model.LiveSession;
import com.example.golive.Repository.LiveSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LiveSessionService {

    private final LiveSessionRepository liveSessionRepository;
    private final GoogleMeetService googleMeetService;
    private final ZoomService zoomService;

    @Autowired
    public LiveSessionService(LiveSessionRepository liveSessionRepository,
                              GoogleMeetService googleMeetService,
                              ZoomService zoomService) {
        this.liveSessionRepository = liveSessionRepository;
        this.googleMeetService = googleMeetService;
        this.zoomService = zoomService;
    }

    public LiveSession createLiveSession(String name, String description, LocalDateTime startTime, LocalDateTime endTime) {
        // Generate meeting links
        String zoomLink = zoomService.createZoomMeeting();
        String googleMeetLink = googleMeetService.createGoogleMeetLink();

        // Create and save the session
        LiveSession session = new LiveSession();
        session.setName(name);
        session.setDescription(description);
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setZoomLink(zoomLink);
        session.setGoogleMeetLink(googleMeetLink);
        return liveSessionRepository.save(session);
    }

    public Optional<LiveSession> getLiveSessionById(Long id) {
        return liveSessionRepository.findById(id);
    }

    public List<LiveSession> getAllLiveSessions() {
        return liveSessionRepository.findAll();
    }

    public void deleteLiveSession(Long id) {
        liveSessionRepository.deleteById(id);
    }

    public LiveSession createLiveSession(LiveSession liveSession) {
        return liveSessionRepository.save(liveSession);
    }
}

