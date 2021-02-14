package spring.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFoundException extends ResourceNotFoundException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
