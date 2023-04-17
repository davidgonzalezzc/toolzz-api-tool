package puj.api.tool.toolapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.service.ToolService;
import puj.api.tool.toolapi.service.ToolServiceImp;

//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

//


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
