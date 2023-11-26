package codes.aliahmad.creatorcorner.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity
{
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String headline;
  private String bio;
}
