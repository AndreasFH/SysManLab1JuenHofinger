package at.fhv.lab1;


import eventside.domain.BookingEvent;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import readside.QueryController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import writeside.CommandController;

import writeside.domain.Booking;
import writeside.domain.Room;

@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan("writeside")
public class WriteSide {

  @Autowired
  private CommandController commandController;



  public static void main(String[] args) {
    SpringApplication.run(WriteSide.class, args);
  }

  @Bean
  public CommandLineRunner write() throws Exception {
    return args -> {

      Room room1 = new Room("r1", 2);
      Room room2 = new Room("r2", 2);

      LocalDate startDate = LocalDate.of(2021, 11, 13);
      LocalDate endDate = LocalDate.of(2021, 11, 20);
      Booking newBooking = new Booking("A1", "Boi", room1, startDate, endDate);
      Booking newBooking2 = new Booking("A2", "Boiii", room2, startDate, endDate);

      System.out.println(commandController.makeBooking(newBooking));
      System.out.println(commandController.makeBooking(newBooking2));
      System.out.println(commandController.makeBooking(newBooking2));

      System.out.println(commandController.cancelBooking("A1"));


    };
  }


}
