package SSVSEM.service.issuedBook.impls;

import SSVSEM.model.IssuedBook;
import SSVSEM.repository.FakeIssuedBookRepository;
import SSVSEM.repository.IssuedBookMongoRepository;
import SSVSEM.service.issuedBook.interfaces.IIssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookServiceImpl
  @version  1.0.0 
  @since 05.08.2021 - 18.41
*/
@Service
public class IssuedBookServiceImpl implements IIssuedBookService {
    @Autowired
    FakeIssuedBookRepository repository;

    @Autowired
    IssuedBookMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<IssuedBook> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public IssuedBook create(IssuedBook issuedBook) {
        issuedBook.setCreatedAt(LocalDateTime.now());
        issuedBook.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(issuedBook);
    }

    @Override
    public IssuedBook get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public IssuedBook update(IssuedBook issuedBook) {
        IssuedBook issuedBookToUpdate = this.get(issuedBook.getId());
        LocalDateTime creation = issuedBookToUpdate.getCreatedAt();
        issuedBook.setCreatedAt(creation);
        issuedBook.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(issuedBook);
    }

    @Override
    public IssuedBook delete(String id) {
        IssuedBook issuedBook = this.get(id);
        mongoRepository.deleteById(id);
        return issuedBook;
    }

    @Override
    public List<IssuedBook> getAll() {
        return mongoRepository.findAll();
    }
}
