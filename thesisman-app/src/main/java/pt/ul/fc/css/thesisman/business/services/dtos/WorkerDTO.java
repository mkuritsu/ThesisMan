package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Worker;

public record WorkerDTO(Long id, String username, String name, String company) implements IUserDTO  {

  public static WorkerDTO fromWorker(Worker worker) {
    if (worker == null)
      return null;
    Long id = worker.getId();
    String username = worker.getUsername();
    String name = worker.getName();
    String company = worker.getCompany();
    return new WorkerDTO(id, username, name, company);
  }
}
