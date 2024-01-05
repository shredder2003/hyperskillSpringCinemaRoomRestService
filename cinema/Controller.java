package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
public class Controller {

    private static Seats seats;
    @GetMapping("/seats")
    public SeatsPublic seats(){
        if(this.seats == null){
            this.seats = new Seats(9,9);
        }
        return seats.getSeatsPublic();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody RowColumn rowColumn){
        Seat seat = seats.getSeat(rowColumn.getRow(), rowColumn.getColumn());
        if(seat==null){
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The number of a row or a column is out of bounds!");
            return ResponseEntity.badRequest().body(Map.of( "error", "The number of a row or a column is out of bounds!"));
        } else if (seat.isBooked()) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The ticket has been already purchased!");
            return ResponseEntity.badRequest().body(Map.of( "error", "The ticket has been already purchased!"));
        } else {
            seat.setBooked(true);
            return ResponseEntity.ok(seat.getSeatPurchase());
        }
    }

    @PostMapping("/return")
    public ResponseEntity<?> purchase(@RequestBody Token token){
        Seat seat = seats.getSeat(token.getToken());
        if(seat==null){
            return ResponseEntity.badRequest().body( Map.of( "error", "Wrong token!" ));
        }else{
            if(seat.isBooked()) {
                seat.setBooked(false);
                return ResponseEntity.ok(seat.getSeatReturn());
            }else{
                return ResponseEntity.badRequest().body( Map.of( "error", "Wrong token!" ));
            }
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(required = false) String password){
        if(password==null || ! password.equals("super_secret")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( Map.of( "error", "The password is wrong!" ));
        }else{
            return ResponseEntity.ok(seats.getStat());
        }
    }

}
