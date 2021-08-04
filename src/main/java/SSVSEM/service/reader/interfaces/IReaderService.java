package SSVSEM.service.reader.interfaces;

import SSVSEM.model.Book;
import SSVSEM.model.Reader;

import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IReaderService
  @version  1.0.0 
  @since 04.08.2021 - 13.13
*/
public interface IReaderService {
    //CRUD
    Reader create(Reader reader);
    Reader get(String id);
    Reader update(Reader reader);
    Reader delete(String id);
    List<Reader> getAll();
}
