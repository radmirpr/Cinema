package web;


import com.cinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/genre/{genre}")
    public List<Film> getFilmsByGenre(@PathVariable String genre) {
        return filmService.getFilmsByGenre(genre);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film filmDetails) {
        Optional<Film> film = filmService.getFilmById(id);
        if (film.isPresent()) {
            Film existingFilm = film.get();
            // Обновляем поля
            existingFilm.setTitle(filmDetails.getTitle());
            existingFilm.setDescription(filmDetails.getDescription());
            existingFilm.setDurationMinutes(filmDetails.getDurationMinutes());
            existingFilm.setGenre(filmDetails.getGenre());
            existingFilm.setAgeRating(filmDetails.getAgeRating());
            existingFilm.setDirector(filmDetails.getDirector());
            existingFilm.setReleaseDate(filmDetails.getReleaseDate());
            existingFilm.setPosterUrl(filmDetails.getPosterUrl());

            Film updatedFilm = filmService.saveFilm(existingFilm);
            return ResponseEntity.ok(updatedFilm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.ok().build();
    }
}