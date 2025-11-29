-- Сброс последовательностей (для H2)
ALTER TABLE users ALTER COLUMN id RESTART WITH 1;
ALTER TABLE films ALTER COLUMN id RESTART WITH 1;
ALTER TABLE cinema_halls ALTER COLUMN id RESTART WITH 1;
ALTER TABLE seats ALTER COLUMN id RESTART WITH 1;
ALTER TABLE screenings ALTER COLUMN id RESTART WITH 1;
ALTER TABLE bookings ALTER COLUMN id RESTART WITH 1;
ALTER TABLE booking_seats ALTER COLUMN id RESTART WITH 1;

-- ===========================================================================
-- Вставка пользователей
-- ===========================================================================
INSERT INTO users (email, password_hash, first_name, last_name, phone, role, is_active, created_at) VALUES
                                                                                                        ('user@cinema.ru', 'temp_password_hash_1', 'Иван', 'Иванов', '+79991234567', 'USER', true, '2024-01-15 10:00:00'),
                                                                                                        ('admin@cinema.ru', 'temp_password_hash_2', 'Админ', 'Админов', '+79997654321', 'ADMIN', true, '2024-01-15 10:00:00'),
                                                                                                        ('manager@cinema.ru', 'temp_password_hash_3', 'Мария', 'Петрова', '+79995556677', 'MANAGER', true, '2024-01-15 10:00:00'),
                                                                                                        ('customer@mail.ru', 'temp_password_hash_4', 'Петр', 'Сидоров', '+79994443322', 'USER', true, '2024-01-16 14:30:00');

-- ===========================================================================
-- Вставка фильмов
-- ===========================================================================
INSERT INTO films (title, description, duration_minutes, genre, age_rating, director, release_date, poster_url) VALUES
                                                                                                                    ('Интерстеллар', 'Фантастический эпос о путешествиях через червоточину', 169, 'SCI_FI', '16+', 'Кристофер Нолан', '2014-11-06', 'https://via.placeholder.com/300x450/3498db/ffffff?text=Interstellar'),
                                                                                                                    ('Начало', 'Триллер о проникновении в сны', 148, 'SCI_FI', '16+', 'Кристофер Нолан', '2010-07-16', 'https://via.placeholder.com/300x450/e74c3c/ffffff?text=Inception'),
                                                                                                                    ('Король Лев', 'Мультфильм о круговороте жизни в саванне', 88, 'ANIMATION', '6+', 'Роджер Аллерс', '1994-06-24', 'https://via.placeholder.com/300x450/2ecc71/ffffff?text=Lion+King');

-- ===========================================================================
-- Вставка кинозалов
-- ===========================================================================
INSERT INTO cinema_halls (name, capacity, layout_rows, layout_columns) VALUES
                                                                           ('Зал 1 - Большой', 150, 10, 15),
                                                                           ('Зал 2 - Средний', 80, 8, 10),
                                                                           ('Зал 3 - VIP', 40, 5, 8);

-- ===========================================================================
-- Вставка мест (упрощенная версия)
-- ===========================================================================
-- Зал 1: несколько мест для примера
INSERT INTO seats (row_number, seat_number, seat_type, hall_id, is_active) VALUES
                                                                               (1, 1, 'VIP', 1, true),
                                                                               (1, 2, 'VIP', 1, true),
                                                                               (2, 1, 'REGULAR', 1, true),
                                                                               (2, 2, 'REGULAR', 1, true);

-- ===========================================================================
-- Вставка сеансов
-- ===========================================================================
INSERT INTO screenings (film_id, hall_id, start_time, end_time, price) VALUES
                                                                           (1, 1, '2024-01-20 18:00:00', '2024-01-20 20:49:00', 400.00),
                                                                           (2, 2, '2024-01-20 19:00:00', '2024-01-20 21:28:00', 350.00),
                                                                           (3, 3, '2024-01-20 20:00:00', '2024-01-20 21:28:00', 500.00);

-- ===========================================================================
-- Вставка бронирований
-- ===========================================================================
INSERT INTO bookings (user_id, screening_id, total_price, status, booking_time, expires_at, payment_status) VALUES
    (1, 1, 800.00, 'CONFIRMED', '2024-01-19 15:30:00', '2024-01-20 17:30:00', 'PAID');

-- ===========================================================================
-- Вставка связи мест и бронирований
-- ===========================================================================
INSERT INTO booking_seats (booking_id, seat_id, screening_id, price) VALUES
                                                                         (1, 1, 1, 400.00),
                                                                         (1, 2, 1, 400.00);