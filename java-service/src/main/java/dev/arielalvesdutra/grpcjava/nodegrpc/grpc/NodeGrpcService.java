package dev.arielalvesdutra.grpcjava.nodegrpc.grpc;

import dev.arielalvesdutra.grpcnode.grpc.NodeGreetingRequest;
import dev.arielalvesdutra.grpcnode.grpc.NodeGreetingResponse;
import dev.arielalvesdutra.grpcnode.grpc.NodeServiceGrpc;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class NodeGrpcService {

    private final NodeServiceGrpc.NodeServiceBlockingStub blockingStub;

    public String callNodeGrpcGreeting(){
        final NodeGreetingRequest request = NodeGreetingRequest
                .newBuilder()
                .setMessage("Mensagem original criado no servidor java")
                .build();
        final NodeGreetingResponse response = blockingStub.greeting(request);

        return response.getMessage();
    }
}
