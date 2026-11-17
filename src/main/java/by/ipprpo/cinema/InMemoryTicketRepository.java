package by.ipprpo.cinema;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTicketRepository implements TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public boolean existsBySessionAndSeat(Session session, int seatNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getSession() == session
                    && ticket.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }
}
