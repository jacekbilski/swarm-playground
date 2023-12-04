package tech.bilski.swarm_playground;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
public class LocalExternalService implements ExternalService {

    @Override
    public Flux<String> getMessages() {
      return Flux.interval(Duration.of(2, ChronoUnit.SECONDS))
          .publishOn(Schedulers.boundedElastic())
          .mapNotNull(n -> "a");
    }
}
