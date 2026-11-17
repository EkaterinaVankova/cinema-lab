package by.ipprpo.cinema;

public interface TicketRepository {
    void save(Ticket ticket);

    boolean existsBySessionAndSeat(Session session, int seatNumber);
}
