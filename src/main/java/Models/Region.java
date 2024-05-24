package Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Region extends BaseModel{
    private String name;
    //private List<Theatre> theatres
    // commeting bcoz we put in threares city id
}
