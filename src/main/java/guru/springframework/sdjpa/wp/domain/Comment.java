package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "wp_comments", indexes = {
    @Index(name = "comment_post_ID", columnList = "comment_post_ID"),
    @Index(name = "comment_approved_date_gmt", columnList = "comment_approved, comment_date_gmt"),
    @Index(name = "comment_date_gmt", columnList = "comment_date_gmt"),
    @Index(name = "comment_parent", columnList = "comment_parent"),
    @Index(name = "comment_author_email", columnList = "comment_author_email")
})
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_ID")
  private Long id;

  @NotNull
  @Column(name = "comment_post_ID")
  private Long postId;

  @NotNull
  @Size(max = 255)
  @Column(name = "comment_author", columnDefinition = "TINYTEXT")
  private String author;

  @Email
  @Column(name = "comment_author_email")
  @Size(max = 100)
  private String authorEmail;

  @Column(name = "comment_author_url")
  @Size(max = 200)
  private String authorUrl;

  @Column(name = "comment_author_IP", length = 100)
  @Size(max = 100)
  private String authorIp;

  @Column(name = "comment_date")
  private Timestamp date;

  @Column(name = "comment_date_gmt")
  private Timestamp dateGmt;

  @Lob
  @NotNull
  @Column(name = "comment_content", columnDefinition = "TEXT")
  private String content;

  @Column(name = "comment_karma")
  private Integer karma;

  @Column(name = "comment_approved")
  @Size(max = 20)
  private String approved;

  @Column(name = "comment_agent")
  @Size(max = 255)
  private String agent;

  @Column(name = "comment_type")
  @Size(max = 20)
  private String type;

  @ManyToOne
  @JoinColumn(name = "comment_parent")
  private Comment parent;

  @ManyToOne
  private User user;

  @OneToMany(mappedBy = "comment")
  private Set<CommentMeta> commentMetaSet;
}
