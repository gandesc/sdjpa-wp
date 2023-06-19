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
//  private Long userId;
  @ManyToOne
  private User user;

  @Length(max = 255)
  @Column(length = 255, columnDefinition = "longtext")
  private String metaKey;
  @Lob
  private String metaValue;
}
