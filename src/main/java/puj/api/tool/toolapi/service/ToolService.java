package puj.api.tool.toolapi.service;

import java.util.List;
import puj.api.tool.toolapi.entity.Tool;

public interface ToolService {
    public List<Tool> listTools();
    public List<Tool> findToolByName(String name);
    public Tool createTool(Tool tool);
    public String delete(Integer id);
    public Tool findToolById(Integer id);
    public List<Tool> findByBrand(Integer brand_id);

    //TODO
    public Tool modifyTool(Tool tool);

}
