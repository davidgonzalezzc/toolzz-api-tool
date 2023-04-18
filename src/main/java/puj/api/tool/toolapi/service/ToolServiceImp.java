package puj.api.tool.toolapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.repository.ToolRepository;

@Service
public class ToolServiceImp implements ToolService{
    /**
     * Inyección de la dependencia toolRepository
     */
    @Autowired
    private ToolRepository toolRepository;
    
    /** 
     * Metodo para haciendo uso de toolRepository listar las herramientas
     * @return lista de herramientas
     */
    @Override
    public List<Tool> listTools() {
        List<Tool> tools = new ArrayList<Tool>();
        tools.addAll(toolRepository.findAll());
        return tools;
        }

    
    /** 
     * Metodo que encuentra una lista de herramientas usando toolRepository
     * @param name Parametro que trae el nombre de la herramienta a buscar
     * @return Retorna una lista de herramientas
     */
    @Override
    public List<Tool> findToolByName(String name) {
        List<Tool> tools = new ArrayList<Tool>();
        tools = toolRepository.findByName(name);
        return tools;
    }

    
    /** 
     * Metodo que encuentra una herramienta a partir del id 
     * @param id id por parametro que representa la herramienta a buscar
     * @return Retorna un objeto de tipo Tool
     */
    @Override
    public Tool findToolById(Integer id) {
        Tool tool = toolRepository.findById(id).get();
        return tool;
    }

    @Override
    public Tool createTool(Tool tool) {
        Tool newtool = new Tool();
        tool.setName(tool.getName());
        tool.setImage(tool.getImage());
        tool.setDescription(tool.getDescription());
        tool.setBrand(tool.getBrand());
        tool.setAmount(tool.getAmount());
        tool.setCities(tool.getCities());
        tool.setPrice(tool.getPrice());
        toolRepository.save(newtool);
        return newtool;
    }

    @Override
    public String delete(Integer id) {
        Tool tool = toolRepository.findById(id).get();
        toolRepository.delete(tool);
        return "deleted";
    }

    @Override
    public Tool modifyTool(Tool tool) {
        Tool newtool = new Tool();
        tool.setName(tool.getName());
        tool.setImage(tool.getImage());
        tool.setDescription(tool.getDescription());
        tool.setBrand(tool.getBrand());
        tool.setAmount(tool.getAmount());
        tool.setCities(tool.getCities());
        tool.setPrice(tool.getPrice());
        toolRepository.save(newtool);
        return newtool;
    }

    @Override
    public List<Tool> findByBrand(Integer brand_id) {
    List<Tool> tools = new ArrayList<Tool>();
    tools = toolRepository.findByBrand(brand_id);
    return tools;    
    }


    
    

}
