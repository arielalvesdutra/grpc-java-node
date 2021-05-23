package dev.arielalvesdutra.grpcjava.grpcserver.server;


import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static java.lang.String.format;

@Slf4j
@RequiredArgsConstructor
@Component
public class JavaGrpcServer {

    private final Server server;

    public void start() throws InterruptedException, IOException {
        log.info(format("Starting java grpc server at port %s", server));
        server.start();
        log.info("java grpc service started with success");
    }
}
