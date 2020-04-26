package pl.bihuniak.ProjektTestowy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Hotel findByName(String name);
    List<Hotel> findByNameOrAddressesCity(String name, String city);
}
