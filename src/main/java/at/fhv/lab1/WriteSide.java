package at.fhv.lab1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.CommandController;
import writeside.domain.Booking;
import writeside.domain.Room;

@SpringBootApplication
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

            //rooms for bookingOne and bookingTwo and bookingThree
            Room room1 = new Room("01", 1);
            Room room2 = new Room("02", 2);
            Room room3 = new Room("03", 3);

            //dates for bookingOne and bookingTwo and bookingThree
            LocalDate startDate = LocalDate.of(2021, 11, 13);
            LocalDate endDate = LocalDate.of(2021, 11, 20);

            //intialize bookingOne and bookingTwo and bookingThree
            Booking bookingOne = new Booking("A1", "CustomerOne", room1, startDate, endDate);
            Booking bookingTwo = new Booking("A2", "CustomerTwo", room2, startDate, endDate);
            Booking bookingThree = new Booking("A3", "CustomerThree", room3, startDate, endDate);

            //syouts
            System.out.println("Is booking " + bookingOne.getBookingNr() + " processed successful in CommandController: " + commandController.makeBooking(bookingOne));
            System.out.println("Is booking " + bookingTwo.getBookingNr() + " processed successful in CommandController: " + commandController.makeBooking(bookingTwo));
            System.out.println("Is booking " + bookingThree.getBookingNr() + " processed successful in CommandController: " + commandController.makeBooking(bookingThree));

            System.out.println("---------------------------------------------");

            System.out.println("Is booking with booking number A1 canceled successful in CommandController: " + commandController.cancelBooking("A1"));

            System.out.println("---------------------------------------------");
        };
    }
}
