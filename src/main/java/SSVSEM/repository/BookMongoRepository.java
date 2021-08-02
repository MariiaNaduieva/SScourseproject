package SSVSEM.repository;

import SSVSEM.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  BookMongoRepository
  @version  1.0.0 
  @since 02.08.2021 - 21.17
*/
@Repository
public interface BookMongoRepository extends MongoRepository<Book,String> {

}
