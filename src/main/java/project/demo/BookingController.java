package project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/bookings")

public class BookingController {
    BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public List<HotelBooking>getAll(){
        return bookingRepository.findAll();
    }
    //http://localhost:8080/bookings/affordable/200.3
    @RequestMapping(value= "/affordable/{price}", method= RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        //bookingslist.stream().filter( x -> x.getPricePerNight()<= price).collect(Collectors.toList());
        return bookingRepository.findByPricePerNightLessThan(price);
    }
    @RequestMapping(value="/create" , method= RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelbooking ){
       // bookingslist.add(hotelbooking);
        bookingRepository.save(hotelbooking);
        return bookingRepository.findAll();
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public  List<HotelBooking> remove(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }
}
