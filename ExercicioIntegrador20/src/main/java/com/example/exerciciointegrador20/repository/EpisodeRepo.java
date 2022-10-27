package com.example.exerciciointegrador20.repository;

import com.example.exerciciointegrador20.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepo extends JpaRepository<Episode, Long> {
    @Query("select ep from Episode ep where ep.id in (select ae.episode.id from ActorEpisode ae where ae.actor.id = :actor_id)")
    List<Episode> getAllByActorEpisodes(Long actor_id);
}
