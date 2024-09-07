package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LogoutRestController {

  @Autowired private HttpSession httpSession;

  @GetMapping("/logout")
  public ResponseEntity<Boolean> logout() {
    httpSession.invalidate();
    return ResponseEntity.ok(true);
  }
}
