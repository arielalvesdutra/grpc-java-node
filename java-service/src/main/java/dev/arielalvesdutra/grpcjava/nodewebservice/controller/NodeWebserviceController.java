package dev.arielalvesdutra.grpcjava.nodewebservice.controller;

import dev.arielalvesdutra.grpcjava.nodewebservice.controller.dto.NodeResponseDTO;
import dev.arielalvesdutra.grpcjava.nodewebservice.httpclient.NodeWebserviceHttpClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("node_webservice")
public class NodeWebserviceController {

    private final NodeWebserviceHttpClient nodeWebserviceHttpClient;

    @GetMapping
    public ResponseEntity<NodeResponseDTO> callingNodeHome() {
        final var httpClientResponse =  nodeWebserviceHttpClient.callNodeHome();
        final var httpClientResponseBody = httpClientResponse.getBody();
        log.info("Node.js webservice response: {}", httpClientResponseBody);
        final var body = NodeResponseDTO
                .builder()
                .message(httpClientResponseBody.getMessage())
                .date(httpClientResponseBody.getDate())
                .javaMark("java mark!")
                .build();

        return ResponseEntity.ok(body);
    }
}


