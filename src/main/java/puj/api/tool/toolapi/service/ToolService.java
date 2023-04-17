package puj.api.tool.toolapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.repository.ToolRepository;

@Service
public class ToolService {
    /**
     *
     */
    @Autowired
    private ToolRepository toolRepository;

    /**
     * @return
     */
    public List<Tool> listTools(){
        return toolRepository.findAll();
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
