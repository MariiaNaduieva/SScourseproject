package SSVSEM.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookCreateForm
  @version  1.0.0 
  @since 05.08.2021 - 20.42
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuedBookCreateForm {
    private String book;
    private String reader;
    private String issueDate;
    private String returnDate;
    private int discount;
    private String desc;
}
