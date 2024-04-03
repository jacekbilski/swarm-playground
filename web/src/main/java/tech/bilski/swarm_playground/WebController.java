package tech.bilski.swarm_playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class WebController {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private final ExternalService service;

  public WebController(ExternalService service) {
    this.service = service;
  }

  @GetMapping("/load-balancing")
  public Rendering loadBalancing() {
    log.info("WebController.loadBalancing");
    return Rendering
        .view("root")
        .modelAttribute("messages", new ReactiveDataDriverContextVariable(service.getMessages(), 1))
        .build();
  }
}
