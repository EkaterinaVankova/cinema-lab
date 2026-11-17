package by.ipprpo.cinema;



public class Ticket {
    private final int id;
    private final Session session;
    private final int seatNumber;

    public Ticket(int id, Session session, int seatNumber) {
        this.id = id;
        this.session = session;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public Session getSession() {
        return session;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
