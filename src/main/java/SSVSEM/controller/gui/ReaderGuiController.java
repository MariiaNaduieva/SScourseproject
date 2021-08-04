package SSVSEM.controller.gui;

import SSVSEM.form.ReaderCreateForm;
import SSVSEM.form.ReaderUpdateForm;
import SSVSEM.model.Reader;
import SSVSEM.service.reader.impls.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderGuiController
  @version  1.0.0 
  @since 04.08.2021 - 13.41
*/
@Controller
@RequestMapping("/gui/reader")
public class ReaderGuiController {
    @Autowired
    ReaderServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Reader> readers = service.getAll();
        model.addAttribute("readers", readers);
        return "readers";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);

        return "redirect:/gui/reader/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        ReaderCreateForm formToCreate = new ReaderCreateForm();
        model.addAttribute("form", formToCreate);
        return "reader-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") ReaderCreateForm form){
        Reader reader = new Reader();
        reader.setName(form.getName());
        reader.setSurname(form.getSurname());
        reader.setPatronymic(form.getPatronymic());
        reader.setAddress(form.getAddress());
        reader.setPhone(form.getPhone());
        reader.setType(form.getType());
        reader.setDesc(form.getDesc());

        service.create(reader);

        return "redirect:/gui/reader/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Reader reader = service.get(id);
        ReaderUpdateForm formToUpdate = new ReaderUpdateForm();

        formToUpdate.setId(reader.getId());
        formToUpdate.setName(reader.getName());
        formToUpdate.setSurname(reader.getSurname());
        formToUpdate.setPatronymic(reader.getPatronymic());
        formToUpdate.setAddress(reader.getAddress());
        formToUpdate.setPhone(reader.getPhone());
        formToUpdate.setType(reader.getType());
        formToUpdate.setDesc(reader.getDesc());
        formToUpdate.setCreatedAt(reader.getCreatedAt());
        formToUpdate.setUpdatedAt(reader.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "reader-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") ReaderUpdateForm form){
        Reader reader = new Reader();
        reader.setId(form.getId());
        reader.setName(form.getName());
        reader.setSurname(form.getSurname());
        reader.setPatronymic(form.getPatronymic());
        reader.setAddress(form.getAddress());
        reader.setPhone(form.getPhone());
        reader.setType(form.getType());
        reader.setDesc(form.getDesc());
        reader.setCreatedAt(form.getCreatedAt());

        service.update(reader);

        return "redirect:/gui/reader/all";
    }
}
