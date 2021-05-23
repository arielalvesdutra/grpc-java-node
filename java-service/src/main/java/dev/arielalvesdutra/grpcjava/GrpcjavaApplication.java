package dev.arielalvesdutra.grpcjava;

import dev.arielalvesdutra.grpcjava.grpcserver.server.JavaGrpcServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class GrpcjavaApplication {

	private final JavaGrpcServer server;

	public static void main(String[] args) {
		log.info("starting project");
		SpringApplication.run(GrpcjavaApplication.class, args);
		log.info("project started");
	}


	@PostConstruct
	public void startGrpcServer() throws IOException, InterruptedException {
		log.info("post constructor :: application is already running");
		server.start();
	}
}
