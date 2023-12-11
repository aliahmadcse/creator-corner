package codes.aliahmad.creatorcorner.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "auth_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity
{
  private String firstName;
  private String lastName;
  private String email;

  //  TODO: should be text field
  private String password;
  private String headline;
  private String bio;
}
