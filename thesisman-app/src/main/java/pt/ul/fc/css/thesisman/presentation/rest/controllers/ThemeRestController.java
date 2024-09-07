package pt.ul.fc.css.thesisman.presentation.rest.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.ul.fc.css.thesisman.business.services.ThemeService;
import pt.ul.fc.css.thesisman.business.services.dtos.IThemeDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.IUserDTO;
import pt.ul.fc.css.thesisman.business.services.dtos.StudentDTO;
import pt.ul.fc.css.thesisman.business.services.exceptions.InvalidFieldException;
import pt.ul.fc.css.thesisman.business.services.exceptions.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("api")
class ThemeRestController {

  @Autowired
  private ThemeService themeService;
  @Autowired
  private HttpSession httpSession;

  @GetMapping("/themes")
  public ResponseEntity<List<IThemeDTO>> listThemesByYear(@RequestParam("year") String year) {
    IUserDTO user = (IUserDTO) httpSession.getAttribute("user");
    if (user instanceof StudentDTO student) {
      try {
        List<IThemeDTO> themes = themeService.getByYear(year, student.mastersDegree().id());
        return ResponseEntity.ok().body(themes);
      } catch (InvalidFieldException | NotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }
}
