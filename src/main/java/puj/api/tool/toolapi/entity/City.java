package puj.api.tool.toolapi.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase para mapear la entidad Ciudad
 *  @Data Anotación de Constructor, getter y setter de lombok
 */
@Data
@Entity
@Table(name="city")
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "cities")
    private List<Tool> availability;

    

}
