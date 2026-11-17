package by.ipprpo.cinema;

public class Application {
    public static void main(String[] args) {

        Movie movie = new Movie(1, "Интерстеллар");
        Session session = new Session(1, movie, 10);

        
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService ticketService = new TicketService(repository);

        System.out.println("Фильм: " + movie.getTitle());
        System.out.println("Количество мест: " + session.getTotalSeats());

        Ticket ticket = ticketService.buyTicket(session, 5);

        System.out.println("Билет успешно куплен.");
        System.out.println("Номер билета: " + ticket.getId());
        System.out.println("Место: " + ticket.getSeatNumber());


        try {
            ticketService.buyTicket(session, 5);
        } catch (IllegalStateException e) {
            System.out.println("Повторная покупка запрещена: " + e.getMessage());
        }

        try {
            ticketService.buyTicket(session, 11);
        } catch (IllegalStateException e) {
            System.out.println("Покупка невозможна: " + e.getMessage());
        }
    }
}
