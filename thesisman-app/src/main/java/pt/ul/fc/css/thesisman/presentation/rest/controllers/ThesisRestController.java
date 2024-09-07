package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.ul.fc.css.thesisman.business.services.ThesisService;
import pt.ul.fc.css.thesisman.business.services.dtos.IUserDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.StudentDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.ThesisDTO;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ThesisRestController {

  @Autowired private ThesisService thesisService;
  @Autowired private HttpSession httpSession;

  @GetMapping("/thesis")
  public ResponseEntity<ThesisDTO> studentThesisList(@RequestParam("studentId") Long studentId) {
    IUserDTO user = (IUserDTO) this.httpSession.getAttribute("user");
    if (!(user instanceof StudentDTO) || !user.id().equals(studentId)) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    Optional<ThesisDTO> thesisFromStudent = thesisService.getThesisFromStudent(studentId);
    if(thesisFromStudent.isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return ResponseEntity.ok().body(thesisFromStudent.get());
  }
}
