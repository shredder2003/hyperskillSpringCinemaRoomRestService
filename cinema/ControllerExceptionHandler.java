package cinema;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//ControllerAdvice
public class ControllerExceptionHandler {
    //ExceptionHandler(FlightNotFoundException.class)
    /*public ResponseEntity<CustomErrorMessage> handleFlightNotFound(
            FlightNotFoundException e, WebRequest request) {

        CustomErrorMessage body = new CustomErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }*/
}
