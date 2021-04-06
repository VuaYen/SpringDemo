package dbconnect2.dbconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
@Configuration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
@Component
class BookingCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        for (Booking b:this.bookingRepository.findAll()){
            System.out.println(b.toString());
        }

    }
    @Autowired
    BookingRepository bookingRepository;
}

interface BookingRepository extends JpaRepository<Booking,Long> {
    Collection<Booking> findByBookingName(String bookingName);
}
@RestController
class BookingRestController{
    @RequestMapping("/bookings")
    Collection<Booking> bookings(){
        return this.bookingRepository.findAll();
    }
    @Autowired
    BookingRepository bookingRepository;
}

@Entity
class Booking{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String bookingName;

    public Booking(String bookingName) {
        this.bookingName = bookingName;
    }
    public Booking(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }
}