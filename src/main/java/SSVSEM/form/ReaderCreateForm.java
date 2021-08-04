package SSVSEM.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderCreateForm
  @version  1.0.0 
  @since 04.08.2021 - 14.51
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderCreateForm {
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;
    private String type;
    private String desc;
}
