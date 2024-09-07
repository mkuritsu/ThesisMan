package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Teacher;

public record TeacherDTO(Long id, String username, String name) implements IUserDTO  {

  public static TeacherDTO fromTeacher(Teacher teacher) {
    if (teacher == null)
      return null;
    return new TeacherDTO(teacher.getId(), teacher.getUsername(), teacher.getName());
  }
}
