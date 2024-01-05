package cinema;

import java.util.*;

public class Seats {
    private int rows = 0;
    private int columns = 0;

    private List<Seat> seats = new ArrayList<>();

    public Seats(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for(int r = 1; r<=rows; r++){
            for(int c = 1; c<=rows; c++) {
                Seat seat = new Seat(r,c, r<=4?10:8, UUID.randomUUID());
                seats.add(seat);
            }
        }
    }

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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Seat getSeat(
            int row, int column
    ) {
        Optional<Seat> seat = seats.stream().filter(s-> s.getRow()==row && s.getColumn()==column).findFirst();
        return seat.orElse(null);
    }

    public SeatsPublic getSeatsPublic() {
        SeatsPublic seatsPublic = new SeatsPublic();
        seatsPublic.setRows( this.getRows() );
        seatsPublic.setColumns( this.getColumns() );
        seats.forEach( s-> seatsPublic.addSeatPublic(s.getSeatPublic()) );
        return seatsPublic;
    }

    public Seat getSeat(
            UUID token
    ) {
        Optional<Seat> seat = seats.stream().filter(s-> s.getToken().equals(token)).findFirst();
        return seat.orElse(null);
    }

    public Map<String, Integer> getStat(){
        final int[] income = {0};
        final int[] purchased = {0};
        seats.forEach( s->{ if(s.isBooked()){
            income[0] +=s.getPrice();
            purchased[0]++;} });
        Map<String, Integer> result = Map.of(
                "income", income[0]
                , "available", this.getRows()*this.getColumns() - purchased[0]
                , "purchased", purchased[0]
        );
        return result;
    }

}
