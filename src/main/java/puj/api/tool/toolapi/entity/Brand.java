package puj.api.tool.toolapi.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para mapear la entidad Brand 
 * @Data Anotación de data de Lombok
 */
@Data
@Entity
@Table(name="brand")
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brand_id;
    
    private String name;
}
