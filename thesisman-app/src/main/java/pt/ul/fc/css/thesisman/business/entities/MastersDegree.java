package pt.ul.fc.css.thesisman.business.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

/**
 * @author 58180 Rodrigo Correia
 * @author 58188 Laura Cunha
 * @author 58640 Guilherme Wind
 *     <p>This class is used to represent a MastersDegree that a student takes.
 */
@Entity
public class MastersDegree {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private @NonNull String name;
  private @NonNull @ManyToOne Teacher admin;

  /**
   * Protected constructor required by JPA, initializes all {@code @NonNull} annotated attributes
   * with default values
   */
  protected MastersDegree() {
    this.name = "Test Masters";
    this.admin = new Teacher();
  }

  /**
   * Creates a new instance of a MastersDegree with the specified {@code admin}, and {@code name}.
   *
   * @param admin The admin of this mastersDegree.
   * @param name The name of this mastersDegree.
   */
  public MastersDegree(@NonNull Teacher admin, @NonNull String name) {
    this.admin = admin;
    this.name = name;
  }

  /**
   * Returns the id of this application.
   *
   * @return The id generated by the database for this application.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Returns the admin of this MastersDegree.
   *
   * @return The admin for this MastersDegree.
   */
  public @NonNull Teacher getAdmin() {
    return this.admin;
  }

  /**
   * Sets the admin for this MastersDegree.
   *
   * @param admin The admin for this MastersDegree.
   */
  public void setAdmin(@NonNull Teacher admin) {
    this.admin = admin;
  }

  /**
   * Returns the name of this MastersDegree.
   *
   * @return The name of this MastersDegree.
   */
  public @NonNull String getName() {
    return this.name;
  }

  /**
   * Sets the name for this MastersDegree.
   *
   * @param name The name given by the admin to replace the old MastersDegree name.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MastersDegree[" + "id=" + id + ", name=" + name + ", admin=" + admin + "]";
  }
}