package SSVSEM.repository;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderMongoRepository
  @version  1.0.0 
  @since 04.08.2021 - 13.40
*/

import SSVSEM.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReaderMongoRepository extends MongoRepository<Reader,String> {
    List<Reader> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
