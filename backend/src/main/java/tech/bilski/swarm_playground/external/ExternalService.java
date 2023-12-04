package tech.bilski.swarm_playground.external;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExternalService {

    public Mono<String> getMessage() {
        return Mono.just("a");
    }
}
