package puj.api.tool.toolapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.service.ToolService;


@RestController
@Slf4j
public class ToolController {
    
    /**
     *
     */
    @Autowired
    private ToolService toolService;

    
    @GetMapping({"/tools",""})
    public List<Tool> listTools(){
        log.info(toolService.listTools().toString());
        return toolService.listTools();
    }

    



}
