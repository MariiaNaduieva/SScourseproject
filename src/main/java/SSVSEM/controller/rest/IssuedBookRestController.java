package SSVSEM.controller.rest;

import SSVSEM.model.IssuedBook;
import SSVSEM.service.issuedBook.impls.IssuedBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookRestController
  @version  1.0.0 
  @since 05.08.2021 - 20.06
*/
@RestController
@RequestMapping("/api/issuedBook")
public class IssuedBookRestController {
    @Autowired
    IssuedBookServiceImpl service;

    @RequestMapping("/all")
    public List<IssuedBook> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public IssuedBook get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public IssuedBook delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public IssuedBook create(@RequestBody IssuedBook issuedBook){
        return service.create(issuedBook);
    }
    @PostMapping("/update")
    public IssuedBook update(@RequestBody IssuedBook issuedBook){
        return service.update(issuedBook);
    }
}
