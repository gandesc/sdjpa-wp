package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "wp_usermeta")
public class UserMeta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "umeta_id")
  private Long id;
  private Long userId;
  @Length(max = 255)
  private String metaKey;
  @Lob
  private String metaValue;
}