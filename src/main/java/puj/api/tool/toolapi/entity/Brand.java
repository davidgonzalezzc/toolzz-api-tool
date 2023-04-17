package puj.api.tool.toolapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="brand")
public class Brand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;
    
    private String name;

}
