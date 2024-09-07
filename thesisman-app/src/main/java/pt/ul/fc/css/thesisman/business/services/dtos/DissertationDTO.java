package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Dissertation;

import java.util.List;

public record DissertationDTO(Long id, String year, String title, String description, List<MastersDegreeDTO> compatibleMasters, TeacherDTO advisor, String state, float remuneration) implements IThemeDTO {

  public static DissertationDTO fromDissertation(Dissertation dissertation) {
    if (dissertation == null)
      return null;
    Long id = dissertation.getId();
    String year = dissertation.getYear();
    String title = dissertation.getTitle();
    String description = dissertation.getDescription();
    List<MastersDegreeDTO> compatibleMasters= dissertation.getCompatibleMasters().stream().map(MastersDegreeDTO::fromMastersDegree).toList();
    TeacherDTO advisor = TeacherDTO.fromTeacher(dissertation.getAdvisor());
    String state = dissertation.getState().toString();
    float remuneration = dissertation.getRemuneration();
    return new DissertationDTO(id, year, title, description, compatibleMasters, advisor, state, remuneration);
  }
}
