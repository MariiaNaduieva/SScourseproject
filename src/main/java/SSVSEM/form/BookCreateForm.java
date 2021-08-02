package SSVSEM.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  BookCreateForm
  @version  1.0.0 
  @since 02.08.2021 - 20.50
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateForm {
    private String title;
    private String author;
    private String genre;
    private double rentalPrice;
    private double bail;
    private String desc;
}
