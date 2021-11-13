package writeside;

import eventside.domain.BookingEvent;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventPublisher {
  private final WebClient localApiClient = WebClient.create("http://localhost:8080");

  public EventPublisher() {
  }

  public Boolean publishMakeBookingEvent(BookingEvent booking) {

    return localApiClient
        .post()
        .uri("/events/makebooking")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(booking),BookingEvent.class)
        .retrieve()
        .bodyToMono(Boolean.class)
        .block();
  }

  public Boolean publishCancelBookingEvent(String bookingNr) {

    return localApiClient
        .post()
        .uri("/events/cancelbooking")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(bookingNr),String.class)
        .retrieve()
        .bodyToMono(Boolean.class)
        .block();
  }
}
