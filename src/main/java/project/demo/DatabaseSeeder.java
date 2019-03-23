package project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookingslist=new ArrayList<>();
        bookingslist.add(new HotelBooking("ghada",200.3,1));
        bookingslist.add(new HotelBooking("ghada amri",100.3,3));
        bookingslist.add(new HotelBooking("ghaaada",700.3,5));
        bookingRepository.saveAll(bookingslist);

    }
}
