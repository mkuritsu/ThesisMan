package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Application;

import java.time.LocalDate;

public record ApplicationDTO(Long id, LocalDate date, StudentDTO student, IThemeDTO theme, String state) {

  public static ApplicationDTO fromApplication(Application application) {
    if (application == null)
      return null;
    Long id = application.getId();
    LocalDate date = application.getDate();
    StudentDTO student = StudentDTO.fromStudent(application.getStudent());
    IThemeDTO theme = IThemeDTO.fromTheme(application.getTheme());
    String state = application.getState().toString();
    return new ApplicationDTO(id, date, student, theme, state);
  }

}
