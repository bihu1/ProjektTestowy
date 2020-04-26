package pl.bihuniak.ProjektTestowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel findHotelById(long id){
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> findHotelByNameOrCity(String name, String city){
        return hotelRepository.findByNameOrAddressesCity(name, city);
    }

    public void deleteHotelById(long id){
        hotelRepository.deleteById(id);
    }

    public Iterable<Hotel> findAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
}
