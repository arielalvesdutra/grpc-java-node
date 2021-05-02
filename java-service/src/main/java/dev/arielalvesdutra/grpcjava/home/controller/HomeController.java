package dev.arielalvesdutra.grpcjava.home.controller;

import dev.arielalvesdutra.grpcjava.home.controller.dto.HomeDTOOut;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Log4j2
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<HomeDTOOut> home() {
        final var body = HomeDTOOut
                .builder()
                .message("Message created on a Java/Spring server")
                .date(LocalDateTime.now())
                .build();
        log.info("returning the following message: {}", body);
        return ResponseEntity.ok(body);
    }
}
