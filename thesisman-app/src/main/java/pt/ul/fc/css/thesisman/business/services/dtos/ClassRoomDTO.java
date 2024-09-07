package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.ClassRoom;

public record ClassRoomDTO(Long id, String designation) {

  public static ClassRoomDTO fromClassRoom(ClassRoom classRoom) {
    if (classRoom == null)
      return null;
    Long id = classRoom.getId();
    String designation = classRoom.getDesignation();
    return new ClassRoomDTO(id, designation);
  }
}
