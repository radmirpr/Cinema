package web;

import com.cinema.entity.Film;
import com.cinema.entity.Genre;
import com.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Film> getFilmsByGenre(String genre) {
        try {
            // Преобразуем строку в enum, заменяя пробелы и дефисы на подчеркивания
            String normalizedGenre = genre.toUpperCase().replaceAll("[\\s-]+", "_");
            Genre genreEnum = Genre.valueOf(normalizedGenre);
            return filmRepository.findByGenre(genreEnum);
        } catch (IllegalArgumentException e) {
            // Если жанр не найден, возвращаем пустой список
            return List.of();
        }
    }

    public List<Film> searchFilmsByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Film> searchFilmsByDirector(String director) {
        return filmRepository.findByDirectorContainingIgnoreCase(director);
    }
}
