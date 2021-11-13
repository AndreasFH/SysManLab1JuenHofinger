package eventside;

import eventside.domain.BookingEvent;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BookingRepository {

  private HashMap<String, BookingEvent> bookings = new HashMap<String, BookingEvent>();

  private final WebClient localApiClient = WebClient.create("http://localhost:8082");

  public boolean makeBooking(BookingEvent booking) {
    bookings.put(booking.getBookingNr(), booking);

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

  public boolean cancelBooking(String bookingNr) throws Exception {
    BookingEvent booking = bookings.remove(bookingNr);

    return localApiClient
        .post()
        .uri("/events/cancelbooking")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(booking),BookingEvent.class)
        .retrieve()
        .bodyToMono(Boolean.class)
        .block();




    }



    // TODO: notify subscribed read repositories via REST
  }


