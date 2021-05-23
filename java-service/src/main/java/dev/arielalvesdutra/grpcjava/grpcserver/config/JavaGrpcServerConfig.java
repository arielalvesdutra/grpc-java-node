package dev.arielalvesdutra.grpcjava.grpcserver.config;

import dev.arielalvesdutra.grpcjava.grpcserver.service.JavaGrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class JavaGrpcServerConfig {

    private static final int SERVER_PORT = 50052;

    @Bean
    public Server server() {
        log.info("injecting grpc server configuration using port {}", SERVER_PORT);
        return ServerBuilder
                .forPort(SERVER_PORT)
                .addService(new JavaGrpcService())
                .build();
    }
}
