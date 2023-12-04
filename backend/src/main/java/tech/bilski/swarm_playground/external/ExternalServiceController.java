package tech.bilski.swarm_playground.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ExternalServiceController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ExternalService service;

    public ExternalServiceController(ExternalService service) {
        this.service = service;
    }

    @GetMapping("/message")
    public Mono<String> getMessage() {
        log.info("ExternalServiceController.hello");
        return service.getMessage();
    }
}
