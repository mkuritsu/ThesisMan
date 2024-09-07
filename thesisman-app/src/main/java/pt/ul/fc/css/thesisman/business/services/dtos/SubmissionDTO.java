package pt.ul.fc.css.thesisman.business.services.dtos;

import pt.ul.fc.css.thesisman.business.entities.Submission;

import java.time.LocalDateTime;

public record SubmissionDTO(Long id, LocalDateTime date, byte[] bytes, String filename, String type, DefenceDTO defence) {

  public static SubmissionDTO fromSubmission(Submission submission) {
    if (submission == null)
      return null;
    Long id = submission.getId();
    LocalDateTime dateTime = submission.getDate();
    byte[] bytes = submission.getBytes();
    String filename = submission.getFilename();
    String type = submission.getType().toString();
    DefenceDTO defence = DefenceDTO.fromDefence(submission.getDefence());
    return new SubmissionDTO(id, dateTime, bytes, filename, type, defence);
  }
}
