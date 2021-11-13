package at.fhv.lab1;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import readside.QueryController;
import writeside.domain.Room;


@SpringBootApplication
@Configuration
@ComponentScan("readside")
public class ReadSide {

  @Autowired
  private QueryController queryController;

  public static void main(String[] args) {
    SpringApplication.run(ReadSide.class, args);
  }

  @Bean
  public CommandLineRunner read() throws Exception {
    return args -> {

      LocalDate d1= LocalDate.of(2020, 1, 8);


     Room r1 = new Room("01", 2);
      Room r2 = new Room("02", 2);
      Room r3 = new Room("03", 4);
      Room r4 = new Room("04", 4);
      Room r5 = new Room("05", 4);

      queryController.addRooms(r1);
      queryController.addRooms(r2);
      queryController.addRooms(r3);
      queryController.addRooms(r4);
      queryController.addRooms(r5);

      queryController.printRooms();

      List<Room> room = queryController.getFreeRooms(d1, d1, 4);

      for(Room r : room){
        System.out.println(r.getRoomNr() + " " + r.getRoomSize());
      }

      Thread.sleep(10000);


  };
  }
}
