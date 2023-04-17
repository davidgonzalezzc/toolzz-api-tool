package puj.api.tool.toolapi.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="city")
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //una herramienta tiene una marca, pero una marca tiene muchas herramientas
    //una herramienta tiene muchas ciudades
    private String name;

    @ManyToMany(mappedBy = "cities")
    private List<Tool> availability;



    /* 
    public Integer getCityId() {
        return id;
    }
    public void setCityId(Integer cityId) {
        this.id = cityId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }*/
    
}
