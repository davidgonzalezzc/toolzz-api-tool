package puj.api.tool.toolapi.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Metodo para mapear entidad de Herramienta
 */
@Data
@Entity
@Table(name="tool")
public class Tool implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String name;
    private String description;
    private Double price;
    private Integer amount;
    
    @ManyToMany
    private List<City> cities;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

}
