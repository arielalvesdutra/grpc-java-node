package dev.arielalvesdutra.grpcjava.nodegrpc.config;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagedChannelConfig {

    public static String TARGET = "localhost:50051";

    @Bean
    public Channel channel() {
        return ManagedChannelBuilder
                .forTarget(TARGET)
                .usePlaintext()
                .build();
    }
}
