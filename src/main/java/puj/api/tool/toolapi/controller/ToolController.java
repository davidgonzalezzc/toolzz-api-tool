package puj.api.tool.toolapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import puj.api.tool.toolapi.entity.Tool;
import puj.api.tool.toolapi.service.ToolService;

/**
 * Clase controlador para manejar las peticiones http
 *  @Slf4j Logger de Lombok
 *  @CrossOrigin Anotación para permitir solicitudes de las url especificadas
 */
@RestController
@RequestMapping("/tools")
//@CrossOrigin(origins="http://localhost:4200")
@Slf4j
public class ToolController {
    
    @Autowired
    private ToolService toolService;
    
    /** 
     * Metodo que trae la lista de herramientas del servicio
     * @return Retorna una lista de herramientas
     */
    @GetMapping("/tool")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Tool> listTools(){
        log.info(toolService.listTools().toString());
        return toolService.listTools();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/searchPaginated")
    public ResponseEntity<Page<Tool>> paginas(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String order,
        @RequestParam(defaultValue = "true") boolean asc
        ){
            Page<Tool> tools = toolService.paginas(PageRequest.of(page,size,Sort.by(order)));
            if(!asc)
                tools = toolService.paginas(PageRequest.of(page,size,Sort.by(order).descending()));
            return new ResponseEntity<Page<Tool>>(tools,HttpStatus.OK);
        }

    /**
     * Metodo que encuentra una herramienta segun su nombre
     * @param name nombre de la herramienta
     * @return retorna una lista de herramientas que tengan el nombre que viene por parametro
     */
    @GetMapping("/tool/byname/{name}")
    public List<Tool> findToolByName(@PathVariable String name){
        return toolService.findToolByName(name);
    }

    /**
     * Metodo para encontrar una herramienta según su id
     * @param id parametro de id de la herramienta
     * @return Retorna una herramienta segun el id proporcionado
     */



    @GetMapping("/tool/byid/{id}")
    public Tool findToolById(@PathVariable Integer id){
        return toolService.findToolById(id);
    }
    
    /**
     * Metodo para crear una herramienta usando el metodo del servicio toolService
     * @param tool parametro de herramienta a crear
     * @return Retorna la herramienta creada
     */
    @PostMapping("/tool")
    public Tool createTool(@RequestBody Tool tool){
        return toolService.createTool(tool);
    }
    
    /**
     * Metodo para eliminar una herramienta según su id
     * @param id parametro id de la herramienta a eliminar
     * @return Retorna un codigo Http segun si es o no eliminado
     */
    @DeleteMapping("/tool/{id}")
    public HttpStatus delete(@PathVariable  Integer id){
        return toolService.delete(id)? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

    /**
     * Metodo que encuentra una herramienta segun la marca 
     * @param brand_id parametro id de la marca
     * @return Retorna una lista de herramientas con la marca que viene por parametro
     */
    @GetMapping("/tool/bybrand/{brand_id}")
    public List<Tool> findByBrand(@PathVariable Integer brand_id){
        return toolService.findByBrand(brand_id);
    }
    
    /**
     * Metodo que modifica una herramienta
     * @param tool parametro de herramienta a modificar
     * @return herramienta ya creada
     */
    @PostMapping("/tool/modify")
    public Tool modifyTool(Tool tool){
        return toolService.createTool(tool);
    }



}
