package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "wp_users", indexes = {
    @Index(name = "user_login_key", columnList = "user_login"),
    @Index(name = "user_nicename", columnList = "user_nicename"),
    @Index(name = "user_email", columnList = "user_email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 60)
    @Column(name = "user_login", nullable = false, length = 60)
    private String user;

    @Length(max = 255)
    @Column(name = "user_pass", nullable = false, length = 255)
    private String password;

    @Length(max = 50)
    @Column(name = "user_nicename", nullable = false, length = 50)
    private String nicename;

    @Email
    @Length(max = 100)
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;

    @URL
    @Length(max = 100)
    @Column(name = "user_url", nullable = false, length = 100)
    private String url;

    @Column(name = "user_registered")
    private Timestamp registered;

    @Length(max = 255)
    @Column(name = "user_activation_key", nullable = false, length = 255)
    private String activationKey;

    @Column(name = "user_status", nullable = false)
    private Integer status;

    @Length(max = 250)
    @Column(nullable = false, length = 250)
    private String displayName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserMeta> userMetaSet;
}
