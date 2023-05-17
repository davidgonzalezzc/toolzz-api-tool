package puj.api.tool.toolapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import puj.api.tool.toolapi.entity.Brand;
import puj.api.tool.toolapi.entity.City;
import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.service.ToolService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(ToolController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToolControllerTests {

    @Autowired
    private MockMvc mockmvc;

    Tool tool;
    @MockBean
    private ToolService toolService;

    @BeforeEach
    void createTool(){
        tool = new Tool("","Martillo","",new Brand(),12.8,new ArrayList<>(),1);
    }

    @Test
    void listToolById(){

        assertEquals(toolService.findToolById(1).getName(),"Martillo");
    }

}
