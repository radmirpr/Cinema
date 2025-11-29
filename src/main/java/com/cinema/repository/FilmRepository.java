package com.cinema.repository;

import com.cinema.entity.Film;
import com.cinema.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByGenre(Genre genre);
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByDirectorContainingIgnoreCase(String director);
}