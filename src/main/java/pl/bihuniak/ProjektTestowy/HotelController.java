package pl.bihuniak.ProjektTestowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bihuniak.ProjektTestowy.model.Hotel;
import pl.bihuniak.ProjektTestowy.model.http.HotelRequest;
import pl.bihuniak.ProjektTestowy.model.http.HotelResponse;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels/{hotelId}")
    public HotelResponse findHotel(@PathVariable long hotelId){
        return hotelService.findHotelById(hotelId);
    }

    @GetMapping("/hotels/filter")
    public List<HotelResponse> findByName(@RequestParam String name, @RequestParam String city){
        return hotelService.findHotelByNameOrCity(name, city);
    }

    @GetMapping("/hotels")
    public Iterable<HotelResponse> findHotel(){
        return hotelService.findAllHotels();
    }

    @PostMapping("/hotels")
    public HotelResponse createHotel(@RequestBody HotelRequest hotel){
        return hotelService.saveHotel(hotel);
    }

    @PutMapping("/hotels/{hotelId}")
    public HotelResponse updateHotel(@RequestBody HotelRequest hotel, @PathVariable long hotelId){
        return hotelService.saveHotel(hotel, hotelId);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable long hotelId){
        hotelService.deleteHotelById(hotelId);
    }
}