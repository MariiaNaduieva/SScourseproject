package SSVSEM.service.issuedBook.interfaces;

import SSVSEM.model.IssuedBook;
import SSVSEM.model.Reader;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IIssuedBookService
  @version  1.0.0 
  @since 05.08.2021 - 18.38
*/
public interface IIssuedBookService {
    IssuedBook create(IssuedBook issuedBook);
    IssuedBook get(String id);
    IssuedBook update(IssuedBook issuedBook);
    IssuedBook delete(String id);
    List<IssuedBook> getAll();
}
