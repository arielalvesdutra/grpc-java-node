package dev.arielalvesdutra.grpcjava.nodegrpc.config;

import dev.arielalvesdutra.grpcnode.grpc.NodeServiceGrpc;
import io.grpc.Channel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BlockingStubConfig {

    @Bean
    public NodeServiceGrpc.NodeServiceBlockingStub blockingStub(Channel channel) {
        return NodeServiceGrpc.newBlockingStub(channel);
    }
}
