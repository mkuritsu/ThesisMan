package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Defence;

import java.time.LocalDateTime;

public record DefenceDTO(Long id, Float grade, LocalDateTime dateTime, int duration, String type, TeacherDTO arguer, TeacherDTO president, ClassRoomDTO classRoom) {

  public static DefenceDTO fromDefence(Defence defence) {
    if (defence == null)
      return null;
    Long id = defence.getId();
    Float grade = defence.getGrade();
    LocalDateTime dateTime = defence.getDateTime();
    int duration = defence.getDuration();
    String type = defence.getType().toString();
    TeacherDTO arguer = TeacherDTO.fromTeacher(defence.getArguer());
    TeacherDTO president = TeacherDTO.fromTeacher(defence.getPresident());
    ClassRoomDTO classRoom = ClassRoomDTO.fromClassRoom(defence.getClassRoom());
    return new DefenceDTO(id, grade, dateTime, duration, type, arguer, president, classRoom);
  }
}
