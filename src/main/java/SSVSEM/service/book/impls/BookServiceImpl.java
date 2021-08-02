package SSVSEM.service.book.impls;

import SSVSEM.model.Book;
import SSVSEM.repository.BookMongoRepository;
import SSVSEM.repository.FakeBookRepository;
import SSVSEM.service.book.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  BookServiceImpl
  @version  1.0.0 
  @since 02.08.2021 - 21.22
*/
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    FakeBookRepository repository;

    @Autowired
    BookMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<Book> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Book create(Book book) {
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(book);
    }

    @Override
    public Book get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Book update(Book book) {
        Book bookToUpdate = this.get(book.getId());
        LocalDateTime creation = bookToUpdate.getCreatedAt();
        book.setCreatedAt(creation);
        book.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(book);
    }

    @Override
    public Book delete(String id) {
        Book book = this.get(id);
        mongoRepository.deleteById(id);
        return book;
    }

    @Override
    public List<Book> getAll() {
        return mongoRepository.findAll();
    }
}
