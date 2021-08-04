package SSVSEM.controller.rest;

import SSVSEM.model.Reader;
import SSVSEM.service.reader.impls.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderRestController
  @version  1.0.0 
  @since 04.08.2021 - 12.59
*/

@RestController
@RequestMapping("/api/reader")
public class ReaderRestController {
    @Autowired
    ReaderServiceImpl service;

    @RequestMapping("/all")
    public List<Reader> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Reader get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Reader delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Reader create(@RequestBody Reader reader){
        return service.create(reader);
    }
    @PostMapping("/update")
    public Reader update(@RequestBody Reader reader){
        return service.update(reader);
    }
}
