package puj.api.tool.toolapi.service;

import java.util.List;
import puj.api.tool.toolapi.entity.Tool;

/*
 * Interfaz que define las funciones para el Servicio de herramientas
 * 
 */
public interface ToolService {
    public List<Tool> listTools();
    public List<Tool> findToolByName(String name);
    public Tool createTool(Tool tool);
    public Boolean delete(Integer id);
    public Tool findToolById(Integer id);
    public List<Tool> findByBrand(Integer brand_id);
    public Tool modifyTool(Tool tool);

}
