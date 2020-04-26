package pl.bihuniak.ProjektTestowy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Hotel findByName(String name);
}
