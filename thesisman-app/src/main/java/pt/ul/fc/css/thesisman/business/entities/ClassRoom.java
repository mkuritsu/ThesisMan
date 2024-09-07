package pt.ul.fc.css.thesisman.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

/**
 * @author 58180 Rodrigo Correia
 * @author 58188 Laura Cunha
 * @author 58640 Guilherme Wind
 *     <p>This class is used to represent a classroom.
 */
@Entity
public class ClassRoom {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull private String designation;

  /**
   * Protected constructor required by JPA, initializes all {@code @NonNull} annotated attributes
   * with default values
   */
  protected ClassRoom() {
    this.designation = "8.2.47";
  }

  /**
   * Creates a new instance of a Classroom with the specified designation.
   *
   * @param designation The designation of this classroom (e.g 8.2.47)
   */
  public ClassRoom(@NonNull String designation) {
    this.designation = designation;
  }

  /**
   * Returns the id of this classroom.
   *
   * @return The id generated by the database for this classroom.
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns the designation of this classroom.
   *
   * @return The designation of this classroom.
   */
  public @NonNull String getDesignation() {
    return designation;
  }

  @Override
  public String toString() {
    return "ClassRoom[" + "id=" + id + ", " + "designation=" + designation + "]";
  }
}
