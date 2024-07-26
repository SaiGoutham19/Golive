package com.example.golive.Repository;

import com.example.golive.Model.LiveSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveSessionRepository extends JpaRepository<LiveSession, Long> {
}
