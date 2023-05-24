package puj.api.tool.toolapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.service.ToolService;

public class ToolControllerTests {
    @Mock
    private ToolService toolService;

    @InjectMocks
    private ToolController toolController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaginas() {
        // Mocking data
        Page<Tool> mockedPage = mock(Page.class);
        when(mockedPage.getContent()).thenReturn(Arrays.asList(new Tool(), new Tool()));

        when(toolService.paginas(any())).thenReturn(mockedPage);

        // Test
        ResponseEntity<Page<Tool>> response = toolController.paginas(0, 10, "id", true);

        // Assertions
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(2, response.getBody().getContent().size());

        // Verify mocks
        verify(toolService, times(1)).paginas(any());
    }

    @Test
    public void testListUsers() {
        // Mocking data
        List<Tool> mockedTools = Arrays.asList(new Tool(), new Tool());
        when(toolService.listTools()).thenReturn(mockedTools);

        // Test
        List<Tool> result = toolController.listTools();

        // Assertions
        Assertions.assertEquals(2, result.size());

        // Verify mocks
        verify(toolService, times(1)).listTools();
    }

    @Test
    public void testFindToolByName() {
        // Mocking data
        String name = "John";
        List<Tool> mockedUsers = Arrays.asList(new Tool(), new Tool());
        when(toolService.findToolByName(name)).thenReturn(mockedUsers);

        // Test
        List<Tool> result = toolController.findToolByName(name);

        // Assertions
        Assertions.assertEquals(2, result.size());

        // Verify mocks
        verify(toolService, times(1)).findToolByName(name);
    }

    @Test
    public void testFindUserById() {
        // Mocking data
        Integer id = 1;
        Tool mockedTool = new Tool();
        when(toolService.findToolById(id)).thenReturn(mockedTool);

        // Test
        Tool result = toolController.findToolById(id);

        // Assertions
        Assertions.assertNotNull(result);

        // Verify mocks
        verify(toolService, times(1)).findToolById(id);
    }

    @Test
    public void testCreateUser() {
        // Mocking data
        Tool tool = new Tool();
        when(toolService.createTool(tool)).thenReturn(tool);

        // Test
        Tool result = toolController.createTool(tool);

        // Assertions
        Assertions.assertNotNull(result);

        // Verify mocks
        verify(toolService, times(1)).createTool(tool);
    }

    @Test
    public void testDelete() {
        // Mocking data
        Integer id = 1;
        when(toolService.delete(id)).thenReturn(true);

        // Test
        HttpStatus result = toolController.delete(id);

        // Assertions
        Assertions.assertEquals(HttpStatus.ACCEPTED, result);

        // Verify mocks
        verify(toolService, times(1)).delete(id);
    }
}