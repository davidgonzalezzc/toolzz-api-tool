package puj.api.tool.toolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.api.tool.toolapi.entity.Tool;

/**
 * Interfaz repositorio para interactuar con la base de datos
 */
public interface ToolRepository extends  JpaRepository<Tool,Integer>{

    public List<Tool> findByBrand(Integer brand_id);
    public List<Tool> findByName(String name);

    

}
