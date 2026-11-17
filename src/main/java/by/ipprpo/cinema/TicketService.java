package by.ipprpo.cinema;



public class TicketService {
    private final TicketRepository ticketRepository;
    private int nextTicketId = 1;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket buyTicket(Session session, int seatNumber) {
        if (!session.isSeatAvailable(seatNumber)) {
            throw new IllegalStateException("Место недоступно: " + seatNumber);
        }
    
        if (ticketRepository.existsBySessionAndSeat(session, seatNumber)) {
            throw new IllegalStateException("Это место уже продано");
        }

        Ticket ticket = new Ticket(nextTicketId++, session, seatNumber);
        session.occupySeat(seatNumber);
        ticketRepository.save(ticket);

        return ticket;
    }
}
