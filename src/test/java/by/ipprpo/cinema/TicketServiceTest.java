package by.ipprpo.cinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    @Test
    void successfulPurchase() {
        Movie movie = new Movie(1, "Интерстеллар");
        Session session = new Session(1, movie, 10);

        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        Ticket ticket = service.buyTicket(session, 5);

        assertNotNull(ticket);
        assertEquals(5, ticket.getSeatNumber());
    }

    @Test
    void occupiedSeat() {
        Movie movie = new Movie(1, "Интерстеллар");
        Session session = new Session(1, movie, 10);

        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        service.buyTicket(session, 5);

        assertThrows(
                IllegalStateException.class,
                () -> service.buyTicket(session, 5)
        );
    }

    @Test
    void unavailableSeat() {
        Movie movie = new Movie(1, "Интерстеллар");
        Session session = new Session(1, movie, 10);

        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        assertThrows(
                IllegalStateException.class,
                () -> service.buyTicket(session, 11)
        );
    }

    @Test
    void invalidSeatNumberZero() {
        Movie movie = new Movie(1, "Интерстеллар");
        Session session = new Session(1, movie, 10);

        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        assertThrows(
                Exception.class,
                () -> service.buyTicket(session, 101)
        );
    }
}