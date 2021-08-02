package SSVSEM.controller.gui;

import SSVSEM.form.BookCreateForm;
import SSVSEM.form.BookUpdateForm;
import SSVSEM.model.Book;
import SSVSEM.service.book.impls.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  BookGuiController
  @version  1.0.0 
  @since 02.08.2021 - 20.04
*/
@Controller
@RequestMapping("/gui/book")
public class BookGuiController {

        @Autowired
        BookServiceImpl service;

        @RequestMapping("/all")
        public String getAll(Model model){
            List<Book> books = service.getAll();
            model.addAttribute("books", books);
            return "books";
        }

        @RequestMapping(value = "/delete/{id}")
        public String delete(Model model, @PathVariable("id") String id){
            service.delete(id);

            return "redirect:/gui/book/all";
        }


        @GetMapping("/create")
        public String create(Model model){
            BookCreateForm formToCreate = new BookCreateForm();
            model.addAttribute("form", formToCreate);
            return "book-create";
        }

        @PostMapping("/create")
        public String create( @ModelAttribute("form") BookCreateForm form){
            Book book = new Book();
            book.setTitle(form.getTitle());
            book.setAuthor(form.getAuthor());
            book.setGenre(form.getGenre());
            book.setRentalPrice(form.getRentalPrice());
            book.setBail(form.getBail());
            book.setDesc(form.getDesc());

            service.create(book);

            return "redirect:/gui/book/all";
        }


        @GetMapping("/update/{id}")
        public String update(Model model, @PathVariable("id") String id){
            Book book = service.get(id);
            BookUpdateForm formToUpdate = new BookUpdateForm();

            formToUpdate.setId(book.getId());
            formToUpdate.setTitle(book.getTitle());
            formToUpdate.setAuthor(book.getAuthor());
            formToUpdate.setGenre(book.getGenre());
            formToUpdate.setRentalPrice(book.getRentalPrice());
            formToUpdate.setBail(book.getBail());
            formToUpdate.setDesc(book.getDesc());
            formToUpdate.setCreatedAt(book.getCreatedAt());
            formToUpdate.setUpdatedAt(book.getUpdatedAt());

            model.addAttribute("form", formToUpdate);
            return "book-update";
        }

        @PostMapping("/update/{id}")
        public String update( @ModelAttribute("form") BookUpdateForm form){
            Book book = new Book();
            book.setId(form.getId());
            book.setTitle(form.getTitle());
            book.setAuthor(form.getAuthor());
            book.setGenre(form.getGenre());
            book.setRentalPrice(form.getRentalPrice());
            book.setBail(form.getBail());
            book.setDesc(form.getDesc());
            book.setCreatedAt(form.getCreatedAt());

            service.update(book);

            return "redirect:/gui/book/all";
        }
    }

