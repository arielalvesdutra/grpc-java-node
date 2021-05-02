package dev.arielalvesdutra.grpcjava.nodewebservice.httpclient;



import dev.arielalvesdutra.grpcjava.nodewebservice.httpclient.dto.NodeHttpClientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NodeWebserviceHttpClient {

    private final RestTemplate restTemplate;
    private final static String NODE_HOME_URL = "http://localhost:3000/";

    public ResponseEntity<NodeHttpClientResponseDTO> callNodeHome() {
        return restTemplate.getForEntity(NODE_HOME_URL, NodeHttpClientResponseDTO.class);
    }
}
