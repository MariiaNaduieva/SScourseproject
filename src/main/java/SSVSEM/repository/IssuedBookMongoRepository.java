package SSVSEM.repository;

import SSVSEM.model.IssuedBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookMongoRepository
  @version  1.0.0 
  @since 05.08.2021 - 19.56
*/
@Repository
public interface IssuedBookMongoRepository extends MongoRepository<IssuedBook,String> {
}
