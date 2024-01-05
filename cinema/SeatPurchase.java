package cinema;

import java.util.UUID;

public class SeatPurchase {
    private UUID token;
    private SeatPublic ticket;

    public SeatPurchase(UUID token, SeatPublic ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public SeatPublic getTicket() {
        return ticket;
    }

    public void setTicket(SeatPublic ticket) {
        this.ticket = ticket;
    }
}
