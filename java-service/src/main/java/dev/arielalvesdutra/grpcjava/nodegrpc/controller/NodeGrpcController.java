package dev.arielalvesdutra.grpcjava.nodegrpc.controller;


import dev.arielalvesdutra.grpcjava.nodegrpc.controller.dto.NodeGrpcResponseDTO;
import dev.arielalvesdutra.grpcjava.nodegrpc.grpc.NodeGrpcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("node_grpcserver")
public class NodeGrpcController {

    private final NodeGrpcService nodeGrpcService;

    @GetMapping
    public ResponseEntity<NodeGrpcResponseDTO> callingNodeGrpcServer() {
        final var grpcResponse = nodeGrpcService.callNodeGrpcGreeting();
        final NodeGrpcResponseDTO body = NodeGrpcResponseDTO
                .builder()
                .message(grpcResponse)
                .date(LocalDateTime.now())
                .javaMark("Java after calling node grpc service")
                .build();

        return ResponseEntity.ok(body);
    }
}
