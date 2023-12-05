package tech.bilski.swarm_playground;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class RemoteExternalService implements ExternalService {

  private final WebClient webClient;

  public RemoteExternalService(WebClient webClient) {
    this.webClient = webClient;
  }

  @Override
  public Flux<String> getMessages() {
    return Flux.interval(Duration.of(2, ChronoUnit.SECONDS))
        .publishOn(Schedulers.boundedElastic())
        .concatMap(this::fetch);
  }

  private Mono<String> fetch(Long x) {
    return webClient.get()
        .uri("http://backend:8080/message")
        .retrieve()
        .bodyToMono(String.class);
  }
}
