package puj.api.tool.toolapi.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para mapear la entidad Ciudad
 *  @Data Anotación de Constructor, getter y setter de lombok
 */
@Data
@Entity
@Table(name="city")
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "cities")
    private List<Tool> tools;

    public City(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    

}
