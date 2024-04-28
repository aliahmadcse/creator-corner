package codes.aliahmad.springauth.user.entity;

import codes.aliahmad.springauth.common.entity.BaseEntity;
import codes.aliahmad.springauth.user.model.ERole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity
{
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  @OneToMany(mappedBy = "role")
  @JsonIgnoreProperties("role")
  private List<User> users;
}
