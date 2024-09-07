package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ul.fc.css.thesisman.business.services.ApplicationService;
import pt.ul.fc.css.thesisman.business.services.dtos.ApplicationDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.IUserDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.StudentDTO;
import pt.ul.fc.css.thesisman.business.services.exceptions.AlreadyExistsException;
import pt.ul.fc.css.thesisman.business.services.exceptions.IncompatiblityException;
import pt.ul.fc.css.thesisman.business.services.exceptions.NotFoundException;
import pt.ul.fc.css.thesisman.business.services.exceptions.StudentMaxApplicationException;
import pt.ul.fc.css.thesisman.presentation.rest.objects.ApplicationCreate;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class ApplicationRestController {

    @Autowired private ApplicationService applicationService;
    @Autowired private HttpSession httpSession;

    @GetMapping("/application")
    public ResponseEntity<List<ApplicationDTO>> studentApplicationsList(@RequestParam("studentId") Long studentId) {
      IUserDTO user = (IUserDTO) httpSession.getAttribute("user");
      if (!(user instanceof StudentDTO) || !user.id().equals(studentId)) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
      try{
        List<ApplicationDTO> applicationsListByStudent = applicationService.studentApplicationsList(studentId);
        return ResponseEntity.ok().body(applicationsListByStudent);
      } catch (NotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/application")
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody ApplicationCreate applicationCreate) {
      Long themeId = applicationCreate.themeId();
      Long studentId = applicationCreate.studentId();
      IUserDTO user = (IUserDTO) httpSession.getAttribute("user");
      if (!(user instanceof StudentDTO) || !user.id().equals(studentId)) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
      try{
        ApplicationDTO application = applicationService.addApplication(themeId, studentId);
        return ResponseEntity.ok().body(application);
      } catch (NotFoundException | StudentMaxApplicationException | AlreadyExistsException | IncompatiblityException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @DeleteMapping("/application/{applicationId}")
    public ResponseEntity<Boolean> cancelApplication(@PathVariable("applicationId") Long applicationId) {
      IUserDTO user = (IUserDTO) httpSession.getAttribute("user");
      if (!(user instanceof StudentDTO)) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
      Optional<ApplicationDTO> applicationOpt = this.applicationService.getById(applicationId);
      if (applicationOpt.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      ApplicationDTO application = applicationOpt.get();
      if (!user.id().equals(application.student().id())) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
      try{
        applicationService.cancelApplication(applicationId);
        return ResponseEntity.ok().body(true);
      }catch (NotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
