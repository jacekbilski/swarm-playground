package tech.bilski.swarm_playground.sessions;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import org.springframework.web.server.WebSession;

@Controller
@RequestMapping("/sessions")
public class SessionsController {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping
  public Rendering session(WebSession session) {
    log.info("SessionsController.session");
    session.start();
    return Rendering
        .view("sessions")
        .modelAttribute("messages", List.of("SessionId: " + session.getId()))
        .build();
  }
}
