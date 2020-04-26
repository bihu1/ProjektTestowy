package pl.bihuniak.ProjektTestowy.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bihuniak.ProjektTestowy.model.Address;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {
    long id;
    String name;
    List<Address> addresses;
}