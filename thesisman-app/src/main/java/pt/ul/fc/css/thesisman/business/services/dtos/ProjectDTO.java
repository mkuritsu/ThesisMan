package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Project;

import java.util.List;

public record ProjectDTO(Long id, String year, String title, String description, List<MastersDegreeDTO> compatibleMasters, TeacherDTO advisor, String state, float remuneration, WorkerDTO worker) implements IThemeDTO {

  public static ProjectDTO fromProject(Project project) {
    if (project == null)
      return null;
    Long id = project.getId();
    String year = project.getYear();
    String title = project.getTitle();
    String description = project.getDescription();
    List<MastersDegreeDTO> compatibleMasters = project.getCompatibleMasters().stream().map(MastersDegreeDTO::fromMastersDegree).toList();
    TeacherDTO advisor = TeacherDTO.fromTeacher(project.getAdvisor());
    String state = project.getState().toString();
    float remuneration = project.getRemuneration();
    WorkerDTO worker = WorkerDTO.fromWorker(project.getEnterpriseAdvisor());
    return new ProjectDTO(id, year, title, description, compatibleMasters, advisor, state, remuneration, worker);
  }

}
