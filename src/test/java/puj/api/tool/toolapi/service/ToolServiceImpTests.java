package puj.api.tool.toolapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.repository.ToolRepository;

public class ToolServiceImpTests {
    
    @Mock
    private ToolRepository toolRepository;

    @InjectMocks
    private ToolServiceImp toolServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListTools() {
        // Arrange
        List<Tool> expectedTools = new ArrayList<>();
        when(toolRepository.findAll()).thenReturn(expectedTools);

        // Act
        List<Tool> actualTools = toolServiceImp.listTools();

        // Assert
        Assertions.assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findAll();
    }
    @Test
    public void testFindToolByName() {
        // Arrange
        String name = "Tool";
        List<Tool> expectedTools = new ArrayList<>();
        when(toolRepository.findByName(name)).thenReturn(expectedTools);

        // Act
        List<Tool> actualTools = toolServiceImp.findToolByName(name);

        // Assert
        Assertions.assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findByName(name);
    }

    @Test
    public void testFindToolById() {
        // Arrange
        Integer id = 1;
        Tool expectedTool = new Tool();
        when(toolRepository.findById(id)).thenReturn(Optional.of(expectedTool));

        // Act
        Tool actualTool = toolServiceImp.findToolById(id);

        // Assert
        Assertions.assertEquals(expectedTool, actualTool);
        verify(toolRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateTool() {
        // Arrange
        Tool tool = new Tool();
        when(toolRepository.save(any(Tool.class))).thenReturn(tool);

        // Act
        Tool createdTool = toolServiceImp.createTool(tool);

        // Assert
        Assertions.assertEquals(tool, createdTool);
        verify(toolRepository, times(1)).save(tool);
    }

    @Test
    public void testDelete() {
        // Arrange
        Integer id = 1;
        Tool tool = new Tool();
        when(toolRepository.findById(id)).thenReturn(Optional.of(tool));

        // Act
        Boolean deleted = toolServiceImp.delete(id);

        // Assert
        Assertions.assertTrue(deleted);
        verify(toolRepository, times(1)).findById(id);
        verify(toolRepository, times(1)).delete(tool);
    }

    @Test
    public void testModifyTool() {
        // Arrange
        Tool tool = new Tool();
        when(toolRepository.save(any(Tool.class))).thenReturn(tool);

        // Act
        Tool modifiedTool = toolServiceImp.modifyTool(tool);

        // Assert
        Assertions.assertEquals(tool, modifiedTool);
        verify(toolRepository, times(1)).save(tool);
    }

    @Test
    public void testFindByBrand() {
        // Arrange
        Integer brandId = 1;
        List<Tool> expectedTools = new ArrayList<>();
        when(toolRepository.findByBrand(brandId)).thenReturn(expectedTools);

        // Act
        List<Tool> actualTools = toolServiceImp.findByBrand(brandId);

        // Assert
        Assertions.assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findByBrand(brandId);
    }

    @Test
    public void testPaginas() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Tool> expectedPage = mock(Page.class);
        when(toolRepository.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Tool> actualPage = toolServiceImp.paginas(pageable);

        // Assert
        Assertions.assertEquals(expectedPage, actualPage);
        verify(toolRepository, times(1)).findAll(pageable);
    }

}
