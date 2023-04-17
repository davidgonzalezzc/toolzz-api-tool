package puj.api.tool.toolapi.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@Entity
@Table(name="tool")
public class Tool {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toolId;
    private String image;
    private String name;
    private String description;
    private Double price;
    private int amount;
    
    @OneToMany
    List<City> ciudades;

    @ManyToOne
    private Brand brand;

    

}
