package codes.aliahmad.creatorcorner.user.entity;


import codes.aliahmad.creatorcorner.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "auth_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class User extends BaseEntity
{
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  //  TODO: should be text field
  private String headline;
  private String bio;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private Role role;
}
