package at.fhv.lab1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import readside.QueryController;
import readside.ReadSideBookingRepository;
import writeside.domain.Booking;
import writeside.domain.Room;

@SpringBootApplication
@Configuration
@ComponentScan("readside")
public class ReadSide {

    @Autowired
    private QueryController queryController;
    @Autowired
    private ReadSideBookingRepository bookingRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReadSide.class, args);
    }

    @Bean
    public CommandLineRunner read() throws Exception {
        return args -> {

            //dates for bookingOne and bookingTwo
            LocalDate startDate = LocalDate.of(2021, 11, 13);
            LocalDate endDate = LocalDate.of(2021, 11, 20);


            Room r1 = new Room("01", 1);
            Room r2 = new Room("02", 2);
            Room r3 = new Room("03", 3);
            Room r4 = new Room("04", 4);
            Room r5 = new Room("05", 5);

            bookingRepository.addRooms(r1);
            bookingRepository.addRooms(r2);
            bookingRepository.addRooms(r3);
            bookingRepository.addRooms(r4);
            bookingRepository.addRooms(r5);

            System.out.println("All rooms: ");
            bookingRepository.printRooms();
            System.out.println("---------------------------------------------");

            //sleep to wait for init of event- and writeside
            TimeUnit.SECONDS.sleep(40);

            List<Room> room = queryController.getFreeRooms(startDate, endDate, 3);

            System.out.println("Free Rooms from 13 - 20.11.2021 for at least 3 persons");
            for (Room r : room) {
                System.out.println(r);
                //System.out.println("room number: " + r.getRoomNr() + ", room size: " + r.getRoomSize());
            }
            System.out.println("---------------------------------------------");

            List<Booking> allBookings = new LinkedList<>();
            allBookings = queryController.getBookings(startDate, endDate);

            System.out.println("All bookings from 13 - 20.11.2021: ");
            for (Booking b : allBookings) {
                System.out.println(b);
            }
        };
    }
}
