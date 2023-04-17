package puj.api.tool.toolapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import puj.api.tool.toolapi.service.ToolService;

@RestController
public class ToolController {
    
    /**
     *
     */
    @Autowired
    private ToolService toolService;
    


}
