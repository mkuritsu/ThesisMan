package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.MastersDegree;

public record MastersDegreeDTO(Long id, String name, TeacherDTO admin) {

  public static MastersDegreeDTO fromMastersDegree(MastersDegree mastersDegree) {
    if (mastersDegree == null)
      return null;
    Long id = mastersDegree.getId();
    String name = mastersDegree.getName();
    TeacherDTO admin = TeacherDTO.fromTeacher(mastersDegree.getAdmin());
    return new MastersDegreeDTO(id, name, admin);
  }
}
