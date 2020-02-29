package spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends javax.persistence.EntityNotFoundException{

    public EmployeeNotFoundException(String name) {
        super(name);
    }
}
