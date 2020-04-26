package pl.bihuniak.ProjektTestowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bihuniak.ProjektTestowy.model.Hotel;
import pl.bihuniak.ProjektTestowy.model.http.HotelRequest;
import pl.bihuniak.ProjektTestowy.model.http.HotelResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelResponse findHotelById(long id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if(hotel != null){
            return new HotelResponse(hotel.getId(), hotel.getName(), hotel.getAddresses());
        }
        return null;
    }

    public List<HotelResponse> findHotelByNameOrCity(String name, String city){
        List<Hotel> hotels = hotelRepository.findByNameOrAddressesCity(name, city);
        List<HotelResponse> hotelResponses = new ArrayList<>();
        for(Hotel hotel:hotels){
            hotelResponses.add(new HotelResponse(hotel.getId(), hotel.getName(), hotel.getAddresses()));
        }
        return hotelResponses;
    }

    public void deleteHotelById(long id){
        hotelRepository.deleteById(id);
    }

    public Iterable<HotelResponse> findAllHotels(){
        Iterable<Hotel> hotels = hotelRepository.findAll();
        List<HotelResponse> hotelResponses = new ArrayList<>();
        for(Hotel hotel:hotels){
            hotelResponses.add(new HotelResponse(hotel.getId(), hotel.getName(), hotel.getAddresses()));
        }
        return hotelResponses;
    }

    public HotelResponse saveHotel(HotelRequest hotelReq){
        Hotel hotel = new Hotel(0, hotelReq.getName(), hotelReq.getAddresses(), false);
        Hotel savedHotel = hotelRepository.save(hotel);
        return new HotelResponse(savedHotel.getId(), savedHotel.getName(), savedHotel.getAddresses());
    }

    public HotelResponse saveHotel(HotelRequest hotelReq, long hotelId){
        Hotel hotel = new Hotel(hotelId, hotelReq.getName(), hotelReq.getAddresses(), false);
        Hotel savedHotel = hotelRepository.save(hotel);
        return new HotelResponse(savedHotel.getId(), savedHotel.getName(), savedHotel.getAddresses());
    }
}
