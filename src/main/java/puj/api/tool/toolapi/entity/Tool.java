package puj.api.tool.toolapi.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Metodo para mapear entidad de Herramienta
 */
@Data
@Entity
@Table(name="tool")
@AllArgsConstructor
@NoArgsConstructor
public class Tool implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String name;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    private Double price;

    @ManyToMany
    private List<City> cities;
    
    private Integer amount;

    public Tool(String image, String name, String description, Brand brand, Double price, List<City> cities,
            Integer amount) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.cities = cities;
        this.amount = amount;
    }    
}
