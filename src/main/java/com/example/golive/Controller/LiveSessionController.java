package com.example.golive.Controller;

import com.example.golive.Model.LiveSession;
import com.example.golive.Service.LiveSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/live-sessions")
public class LiveSessionController {
    private final LiveSessionService liveSessionService;

    @Autowired
    public LiveSessionController(LiveSessionService liveSessionService) {
        this.liveSessionService = liveSessionService;
    }

    @PostMapping
    public ResponseEntity<LiveSession> createLiveSession(@RequestBody LiveSession liveSession) {
        LiveSession createdSession = liveSessionService.createLiveSession(liveSession);
        return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
    }

    @PostMapping("/start")
    public LiveSession startLiveSession(@RequestParam String name,
                                        @RequestParam String description,
                                        @RequestParam LocalDateTime startTime,
                                        @RequestParam LocalDateTime endTime) {
        return liveSessionService.createLiveSession(name, description, startTime, endTime);
    }

    @GetMapping("/id")
    public Optional<LiveSession> getLiveSession(@PathVariable Long id) {
        return liveSessionService.getLiveSessionById(id);
    }

    @GetMapping("api/live-sessions")
    public List<LiveSession> getAllLiveSessions() {
        return liveSessionService.getAllLiveSessions();
    }

    @DeleteMapping("/end/{id}")
    public void endLiveSession(@PathVariable Long id) {
        liveSessionService.deleteLiveSession(id);
    }
}
