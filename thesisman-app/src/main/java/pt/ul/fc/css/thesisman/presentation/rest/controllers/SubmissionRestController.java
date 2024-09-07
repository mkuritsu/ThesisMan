package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pt.ul.fc.css.thesisman.business.entities.Submission;
import pt.ul.fc.css.thesisman.business.exceptions.SubmissionNotFoundException;
import pt.ul.fc.css.thesisman.business.exceptions.ThesisNotFoundException;
import pt.ul.fc.css.thesisman.business.services.SubmissionService;
import pt.ul.fc.css.thesisman.business.services.dtos.SubmissionDTO;
import pt.ul.fc.css.thesisman.business.services.exceptions.InvalidFieldException;
import pt.ul.fc.css.thesisman.business.services.exceptions.NotFoundException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
public class SubmissionRestController {

  @Autowired private SubmissionService submissionService;

  @PostMapping("/submission/propose")
  public ResponseEntity<SubmissionDTO> submitProposalDocument(@RequestParam("thesisId") Long thesisId, @RequestParam("file") MultipartFile file) {
    try {
      SubmissionDTO submission = submissionService.submitProposalDocument(thesisId, file.getBytes(), file.getOriginalFilename());
      return ResponseEntity.ok().body(submission);
    } catch (NotFoundException | InvalidFieldException | IOException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/submission/final")
  public ResponseEntity<SubmissionDTO> submitFinalDocument(@RequestParam("thesisId") Long thesisId, @RequestParam("file") MultipartFile file) {
    try {
      SubmissionDTO submission = submissionService.submitFinalDocument(thesisId, file.getBytes(), file.getOriginalFilename());
      return ResponseEntity.ok().body(submission);
    } catch (NotFoundException | InvalidFieldException | IOException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/submission/final")
  public ResponseEntity<Submission> loadFinal(@RequestParam("thesisId") Long thesisId) {
    try {
      return ResponseEntity.ok().body(submissionService.loadFinal(thesisId));
    } catch (SubmissionNotFoundException | ThesisNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/submission/proposals")
  public ResponseEntity<List<Submission>> loadProposals(@RequestParam("thesisId") Long thesisId) {
    try {
      return ResponseEntity.ok().body(submissionService.loadProposals(thesisId));
    } catch (ThesisNotFoundException | SubmissionNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
