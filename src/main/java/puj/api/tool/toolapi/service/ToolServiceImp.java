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
     *
     */
    @Autowired
    private ToolRepository toolRepository;

    @Override
    public List<Tool> listTools() {
        List<Tool> tools = new ArrayList<Tool>();
        tools.addAll(toolRepository.findAll());
        return tools;
        }


    /**
     * @param tool
     * @return
     */
    public Tool saveTool(Tool tool){
        return toolRepository.save(tool);
    }


    /**
     * @param id
     */
    public void delete(Integer id){
        toolRepository.deleteById(id);
    }


    /**
     * @param name
     * @return
     */
    public List<Tool> findToolByName(String name){
        return toolRepository.findToolByName(name);
    }



}
