package cinema;

import java.util.ArrayList;
import java.util.List;

public class SeatsPublic {
    private int rows = 0;
    private int columns = 0;

    private List<SeatPublic> seats = new ArrayList<>();

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<SeatPublic> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatPublic> seats) {
        this.seats = seats;
    }

    public void addSeatPublic(SeatPublic seatPublic) {
        this.seats.add(seatPublic);
    }

}
