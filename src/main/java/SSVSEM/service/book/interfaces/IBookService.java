package SSVSEM.service.book.interfaces;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IBookService
  @version  1.0.0 
  @since 02.08.2021 - 21.26
*/

import SSVSEM.model.Book;

import java.util.List;

public interface IBookService {
    //CRUD
    Book create(Book book);
    Book get(String id);
    Book update(Book book);
    Book delete(String id);
    List<Book> getAll();

}
