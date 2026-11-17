package by.ipprpo.cinema;

import java.util.HashSet;
import java.util.Set;

public class Session {
    private final int id;
    private final Movie movie;
    private final int totalSeats;
    private final Set<Integer> occupiedSeats = new HashSet<>();

    public Session(int id, Movie movie, int totalSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Количество мест должно быть больше 0");
        }

        this.id = id;
        this.movie = movie;
        this.totalSeats = totalSeats;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return seatNumber >= 1
                && seatNumber <= totalSeats
                && !occupiedSeats.contains(seatNumber);
    }

    public void occupySeat(int seatNumber) {
        if (!isSeatAvailable(seatNumber)) {
            throw new IllegalArgumentException("Место недоступно: " + seatNumber);
        }
        occupiedSeats.add(seatNumber);
    }
}
