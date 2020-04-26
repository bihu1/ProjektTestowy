package pl.bihuniak.ProjektTestowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels/{hotelId}")
    public Hotel findHotel(@PathVariable long hotelId){
        return hotelService.findHotelById(hotelId);
    }

    @GetMapping("/hotels/filter")
    public List<Hotel> findByName(@RequestParam String name, @RequestParam String city){
        return hotelService.findHotelByNameOrCity(name, city);
    }

    @GetMapping("/hotels")
    public Iterable<Hotel> findHotel(){
        return hotelService.findAllHotels();
    }

    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }

    @PutMapping("/hotels")
    public Hotel updateHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable long hotelId){
        hotelService.deleteHotelById(hotelId);
    }
}