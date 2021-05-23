package dev.arielalvesdutra.grpcjava.grpcserver.service;

import dev.arielalvesdutra.grpcjava.grpc.JavaGreetingRequest;
import dev.arielalvesdutra.grpcjava.grpc.JavaGreetingResponse;
import dev.arielalvesdutra.grpcjava.grpc.JavaServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Log4j2
@RequiredArgsConstructor
@Service
public class JavaGrpcService extends JavaServiceGrpc.JavaServiceImplBase  {

    @Override
    public void greeting(
            JavaGreetingRequest request,
            StreamObserver<JavaGreetingResponse> responseObserver) {

        final String  requestMessage = request.getMessage();
        final String greetingMessage = format("message received on the java grpc server: %s", requestMessage);

        log.info(greetingMessage);
        final JavaGreetingResponse responseDTO = JavaGreetingResponse.
                newBuilder()
                .setMessage(greetingMessage)
                .build();

        responseObserver.onNext(responseDTO);
        responseObserver.onCompleted();
    }
}
