package spring.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends ResourceNotFoundException{

    private Date date = new Date();
    private String message;
    private String details;


    public EmployeeNotFoundException(String message, Date date,String details) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public EmployeeNotFoundException(int employeeId) {
        this.message ="Employee with Id:" + employeeId + " not found" ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
