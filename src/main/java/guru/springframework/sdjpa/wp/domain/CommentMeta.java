package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wp_commentmeta", indexes = {
    @Index(name = "comment_id", columnList = "comment_id"),
    @Index(name = "meta_key", columnList = "meta_key")
})
public class CommentMeta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "meta_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "comment_id")
  private Comment comment;

  @Column(name = "meta_key")
  @Size(max = 255)
  private String metaKey;

  @Lob
  @NotNull
  @Column(name = "meta_value", columnDefinition = "LONGTEXT")
  private String metaValue;

}
