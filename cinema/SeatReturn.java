package cinema;

public class SeatReturn {
    private SeatPublic ticket;

    public SeatReturn(SeatPublic ticket) {
        this.ticket = ticket;
    }

    public SeatPublic getTicket() {
        return ticket;
    }

    public void setTicket(SeatPublic ticket) {
        this.ticket = ticket;
    }
}
