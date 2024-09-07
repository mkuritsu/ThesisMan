package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.ul.fc.css.thesisman.business.services.AuthenticationService;
import pt.ul.fc.css.thesisman.business.services.dtos.IUserDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.StudentDTO;
import pt.ul.fc.css.thesisman.business.services.exceptions.InvalidFieldException;
import pt.ul.fc.css.thesisman.business.services.exceptions.NotFoundException;

@RestController
@RequestMapping("api")
public class StudentRestController {

  @Autowired private AuthenticationService authenticationService;
  @Autowired private HttpSession httpSession;

  @GetMapping("/student")
  public ResponseEntity<IUserDTO> authenticateStudent(@RequestParam("username") String username, @RequestParam("password") String password) {
    try{
      IUserDTO user = authenticationService.authenticate(username, password);
      if (!(user instanceof StudentDTO)) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }
      this.httpSession.setAttribute("user", user);
      return ResponseEntity.ok().body(user);
    } catch (InvalidFieldException | NotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
