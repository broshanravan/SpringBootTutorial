package spring.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
class HealthCheckController {


    String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> healthcheck(@RequestParam  String format, ResponseEntity response) {
        String status = "";
        if ("short".equalsIgnoreCase("format")){
            status = "{\"status\": \"OK\"  + }";
            return new ResponseEntity(status,HttpStatus.OK );
        }else if("full".equalsIgnoreCase("format")){
            String time =simpleDateFormat.format(new Date());
            status = "{ \"currentTime:" + time + ",\"application\": \"OK\" }";
            return new ResponseEntity(status,HttpStatus.OK );
        }else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

    }


    @PutMapping(value = "/healthcheck")
    public void healthcheckPut() {
        return;
    }

    @PostMapping(value = "/healthcheck")
    public void healthcheckPost() {
        return;
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        return;
    }

}
