package SSVSEM.service.reader.impls;


import SSVSEM.model.Reader;
import SSVSEM.repository.FakeReaderRepository;
import SSVSEM.repository.ReaderMongoRepository;
import SSVSEM.service.reader.interfaces.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderServiceImpl
  @version  1.0.0 
  @since 04.08.2021 - 13.07
*/

@Service
public class ReaderServiceImpl implements IReaderService {
    @Autowired
    FakeReaderRepository repository;

    @Autowired
    ReaderMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<Reader> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Reader create(Reader reader) {
        reader.setCreatedAt(LocalDateTime.now());
        reader.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(reader);
    }

    @Override
    public Reader get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Reader update(Reader reader) {
        Reader readerToUpdate = this.get(reader.getId());
        LocalDateTime creation = readerToUpdate.getCreatedAt();
        reader.setCreatedAt(creation);
        reader.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(reader);
    }

    @Override
    public Reader delete(String id) {
        Reader reader = this.get(id);
        mongoRepository.deleteById(id);
        return reader;
    }

    @Override
    public List<Reader> getAll() {
        return mongoRepository.findAll();
    }
}
