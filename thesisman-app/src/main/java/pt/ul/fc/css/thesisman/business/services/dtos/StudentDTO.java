package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Student;

public record StudentDTO(Long id, String username, String name, MastersDegreeDTO mastersDegree, Float grade, String password) implements IUserDTO {

  public static StudentDTO fromStudent(Student student) {
    if (student == null)
      return null;
    Long id = student.getId();
    String username = student.getUsername();
    String name = student.getName();
    MastersDegreeDTO mastersDegree = MastersDegreeDTO.fromMastersDegree(student.getMastersDegree());
    Float grade = student.getGrade();
    String password = student.getPassword();
    return new StudentDTO(id, username, name, mastersDegree, grade, password);
  }
}
