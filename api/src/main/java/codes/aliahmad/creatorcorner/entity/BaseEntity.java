package codes.aliahmad.creatorcorner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "created_at")
  private LocalDateTime createdOn;

  @Column(name = "last_modified_at")
  private LocalDateTime lastModifiedOn;

  @Version
  private Integer version;

  @PrePersist
  public void prePersist()
  {
    createdOn = LocalDateTime.now();
    lastModifiedOn = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate()
  {
    lastModifiedOn = LocalDateTime.now();
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (!(o instanceof BaseEntity that))
    {
      return false;
    }
    return Objects.equals(id, that.id) && getClass().equals(that.getClass());
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id);
  }
}
