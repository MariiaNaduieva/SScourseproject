package SSVSEM.controller.gui;

import SSVSEM.form.IssuedBookCreateForm;
import SSVSEM.form.IssuedBookUpdateForm;
import SSVSEM.model.Book;
import SSVSEM.model.IssuedBook;
import SSVSEM.model.Reader;
import SSVSEM.repository.BookMongoRepository;
import SSVSEM.repository.ReaderMongoRepository;
import SSVSEM.service.issuedBook.impls.IssuedBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookGuiController
  @version  1.0.0 
  @since 05.08.2021 - 20.09
*/
@Controller
@RequestMapping("/gui/issuedBook")
public class IssuedBookGuiController {
    @Autowired
    private IssuedBookServiceImpl service;

    @Autowired
    private BookMongoRepository bookMongoRepository;

    @Autowired
    private ReaderMongoRepository readerMongoRepository;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<IssuedBookUpdateForm> issuedBooks = service.getAll().stream()
                .map(IssuedBookUpdateForm::new)
                .collect(Collectors.toList());
        model.addAttribute("issuedBooks", issuedBooks);
        return "issuedBooks";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/issuedBook/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        IssuedBookCreateForm formToCreate = new IssuedBookCreateForm();
        model.addAttribute("form", formToCreate);
        return "issuedBook-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") IssuedBookCreateForm form){
        IssuedBook issuedBook = new IssuedBook();
        Book book = bookMongoRepository.findByTitle(form.getBook()).get(0);
        String[] readerData = form.getReader().split(" ");
        Reader reader = readerMongoRepository.findByNameAndSurnameAndPatronymic(readerData[0], readerData[1], readerData[2])
                .get(0);
        issuedBook.setIssueDate(form.getIssueDate());
        issuedBook.setReturnDate(form.getReturnDate());
        issuedBook.setDiscount(form.getDiscount());
        issuedBook.setDesc(form.getDesc());
        issuedBook.setBook(book);
        issuedBook.setReader(reader);
        service.create(issuedBook);
        return "redirect:/gui/issuedBook/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        IssuedBookUpdateForm formToUpdate = new IssuedBookUpdateForm(service.get(id));
        model.addAttribute("form", formToUpdate);
        return "issuedBook-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") IssuedBookUpdateForm form, @PathVariable("id") String id){
        IssuedBook issuedBook = service.get(id);
        Book book = bookMongoRepository.findByTitle(form.getBook()).get(0);
        String[] readerData = form.getReader().split(" ");
        Reader reader = readerMongoRepository.findByNameAndSurnameAndPatronymic(readerData[0], readerData[1], readerData[2])
                .get(0);
        issuedBook.setBook(book);
        issuedBook.setReader(reader);
        issuedBook.setIssueDate(form.getIssueDate());
        issuedBook.setReturnDate(form.getReturnDate());
        issuedBook.setDiscount(form.getDiscount());
        issuedBook.setDesc(form.getDesc());
        service.update(issuedBook);
        return "redirect:/gui/issuedBook/all";
    }
}
