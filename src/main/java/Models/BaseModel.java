package Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    //@Id tell spring create primary key
    // generatedvalue gives autoincrement value for primary key
    //mappedsuper class add below 3 attributes in every class which extends this class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date CreatedAt;
    private Date  lastModifiedAt;

}
