package pt.ul.fc.css.thesisman.business.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import pt.ul.fc.css.thesisman.business.enums.ApplicationState;

import java.time.LocalDate;

/**
 * @author 58180 Rodrigo Correia
 * @author 58188 Laura Cunha
 * @author 58640 Guilherme Wind
 *     <p>This class is used to represent an application that a student makes to a certain Theme.
 */
@Entity
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  @Column(columnDefinition = "DATE")
  private LocalDate date = LocalDate.now();

  @NonNull
  @Enumerated(EnumType.STRING)
  private ApplicationState state = ApplicationState.SUBMITTED;

  @NonNull @ManyToOne private Theme theme;

  @NonNull @ManyToOne private Student student;

  /**
   * Protected constructor required by JPA, initializes all {@code @NonNull} annotated attributes
   * with default values
   */
  protected Application() {
    this.theme = new Dissertation();
    this.student = new Student();
  }

  /**
   * Creates a new instance of an Application with the specified {@code Theme} and {@code Student}.
   *
   * @param theme The theme this application is for.
   * @param student The student that makes this application.
   */
  public Application(@NonNull Theme theme, @NonNull Student student) {
    this.theme = theme;
    this.student = student;
  }

  /**
   * Returns the id of this application.
   *
   * @return The id generated by the database for this application.
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns the submission date of this application.
   *
   * @return Submission date of the application.
   */
  public @NonNull LocalDate getDate() {
    return date;
  }

  /**
   * Returns the current state of this application.
   *
   * @return The current state of the application.
   */
  public @NonNull ApplicationState getState() {
    return state;
  }

  /**
   * Changes the state of the application.
   *
   * @param state The new state of the application.
   */
  public void setState(@NonNull ApplicationState state) {
    this.state = state;
  }

  /**
   * Returns the theme this application is for.
   *
   * @return The theme this application is for.
   */
  public @NonNull Theme getTheme() {
    return theme;
  }

  /**
   * Returns the student that made this application.
   *
   * @return The student that made this application.
   */
  public @NonNull Student getStudent() {
    return student;
  }

  @Override
  public String toString() {
    return "Application ["
        + "id="
        + id
        + ", date="
        + date
        + ", state="
        + state
        + ", theme="
        + theme
        + ']';
  }
}
