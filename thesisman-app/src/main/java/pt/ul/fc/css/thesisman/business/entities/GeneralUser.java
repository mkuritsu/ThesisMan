package pt.ul.fc.css.thesisman.business.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

/**
 * @author 58180 Rodrigo Correia
 * @author 58188 Laura Cunha
 * @author 58640 Guilherme Wind
 *     <p>This class is used to represent a User.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GeneralUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  @NonNull
  private String username;

  @NonNull private String password;

  @NonNull private String name;

  /**
   * Protected constructor required by JPA, initializes all {@code @NonNull} annotated attributes
   * with default values.
   */
  protected GeneralUser() {
    this.username = "username";
    this.password = "password";
    this.name = "name";
  }

  /**
   * Creates a new instance of a GeneralUser with the specified username, password and name.
   *
   * @param username The username of the user.
   * @param password The password of the user.
   * @param name The name of the user.
   */
  protected GeneralUser(@NonNull String username, @NonNull String password, @NonNull String name) {
    this.username = username;
    this.password = password;
    this.name = name;
  }

  /**
   * Returns the id of this user.
   *
   * @return The id generated by the database for this user.
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns the username of this user.
   *
   * @return The username of this user.
   */
  public @NonNull String getUsername() {
    return username;
  }

  /**
   * Returns the password of this user.
   *
   * @return The password of this user.
   */
  public @NonNull String getPassword() {
    return password;
  }

  /**
   * Sets the password for this user.
   *
   * @param password The password given by the user to replace the old password.
   */
  public void setPassword(@NonNull String password) {
    this.password = password;
  }

  /**
   * Returns the name of this user.
   *
   * @return The name of this user.
   */
  public @NonNull String getName() {
    return name;
  }

  /**
   * Sets the name for this user.
   *
   * @param name The name given by the user to replace the old name.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }
}