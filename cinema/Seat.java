package cinema;

import java.util.UUID;

public class Seat {
    private int row = 0;
    private int column = 0;
    private int price = 0;
    private boolean booked = false;
    private UUID token;

    public Seat(int row, int column, int price, UUID token) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.booked = false;
        this.token = token;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    public SeatPublic getSeatPublic() {
        return new SeatPublic(this.getRow(), this.getColumn(), this.getPrice());
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public SeatPurchase getSeatPurchase() {
        return new SeatPurchase(this.getToken(), this.getSeatPublic() );
    }

    public SeatReturn getSeatReturn() {
        return new SeatReturn( this.getSeatPublic() );
    }
}
