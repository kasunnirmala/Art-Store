package lk.artstore.spring.controller;

import lk.artstore.spring.dto.PaintDTO;
import lk.artstore.spring.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class PaintController {
    @Autowired
    private PaintService paintService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PaintDTO> getAllPaintings(){
        return paintService.getAllPaintings();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaintDTO getPainting(@PathVariable("id") int id){
        return paintService.getPainting(id);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deletePainting(@PathVariable("id") int id) {
        return paintService.deletePainting(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody PaintDTO paintDTO){
        return paintService.savePainting(paintDTO);
    }

}
