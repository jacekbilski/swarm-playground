package tech.bilski.swarm_playground.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExternalService {

  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private final String hostname;
  private final String replica;

  public ExternalService() {
    hostname = System.getenv("HOSTNAME");
    replica = System.getenv("REPLICA");
  }

  public Mono<String> getMessage() {
    log.info("ExternalService[h:{},r:{}].message", hostname, replica);
    return Mono.just(String.format("ExternalService (external, h: '%s', r: '%s') sends greetings!", hostname, replica));
  }
}
