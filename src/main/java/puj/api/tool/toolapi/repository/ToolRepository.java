package puj.api.tool.toolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import puj.api.tool.toolapi.entity.Tool;

public interface ToolRepository extends  JpaRepository<Tool,Integer>{


    /**
     * @param brandId
     * @return
     */
    @Query(value = "SELECT * FROM tools WHERE tools.toolId = :brandId", nativeQuery = true)
        public List<Tool> findByBrand(@Param("brandId")Integer brandId);

    /**
     * @param name
     * @return
     */
    @Query(value="SELECT * FROM tools where name like %:name%", nativeQuery = true)
    public List<Tool> findToolByName(@Param("name") String name);


}
