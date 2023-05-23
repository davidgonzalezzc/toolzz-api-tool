package puj.api.tool.toolapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.repository.ToolRepository;

/**
 * Clase que implementa la interfaz para el crud de herramientas
 * @implements interfaz que define los metodos de listar, eliminar, modificar etc
 */
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

    
    /** 
     * Metodo para crear una herramienta a traves del repositorio jpa toolRepository
     * @param newtool
     * @return Retorna un objeto de tipo herramienta ya mapeado
     */
    @Override
    public Tool createTool(Tool tool) {
        Tool newtool = new Tool();
        newtool.setImage(tool.getImage());
        newtool.setName(tool.getName());
        newtool.setDescription(tool.getDescription());
        newtool.setBrand(tool.getBrand());
        newtool.setPrice(tool.getPrice());
        newtool.setCities(tool.getCities());
        newtool.setAmount(tool.getAmount());
        toolRepository.save(newtool);
        return newtool;
    }


    
    /** 
     * Metodo que elimina una herramienta segun el id que se le pase por parametro
     * @param id id de la herramienta
     * @return True si se elimino, falso si no
     */
    @Override
    public Boolean delete(Integer id) {
        Tool tool = toolRepository.findById(id).get();
        toolRepository.delete(tool);
        return true;
    }


    
    /** 
     * Metodo para modificar una herramienta, ya viene la herramienta
     * @param tool Herramienta a modificar
     * @return Retorna la herramienta ya modificada
     */
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


    
    /** 
     * Metodo para traer una lista de herramientas segun una marca en especifico
     * @param brand_id id de la marca a filtrar
     * @return Retorna una lista de herramientas segun una marca
     */
    @Override
    public List<Tool> findByBrand(Integer brand_id) {
    List<Tool> tools = new ArrayList<Tool>();
    tools = toolRepository.findByBrand(brand_id);
    return tools;    
    }


    @Override
    public Page<Tool> paginas(Pageable pageable) {
        return toolRepository.findAll(pageable);
    }
    

}
