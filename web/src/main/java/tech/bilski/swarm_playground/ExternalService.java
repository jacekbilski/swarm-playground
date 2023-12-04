package tech.bilski.swarm_playground;

import reactor.core.publisher.Flux;

public interface ExternalService {
    Flux<String> getMessages();
}
