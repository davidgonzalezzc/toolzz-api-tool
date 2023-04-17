package puj.api.tool.toolapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    //una herramienta tiene una marca, pero una marca tiene muchas herramientas
    //una herramienta tiene muchas ciudades
    private String name;
    
}
