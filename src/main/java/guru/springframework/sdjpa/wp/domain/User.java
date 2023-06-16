package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "wp_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 60)
    @Column(name = "user_login", nullable = false)
    private String user;

    @Length(max = 255)
    @Column(name = "user_pass", nullable = false)
    private String password;

    @Length(max = 50)
    @Column(name = "user_nicename", nullable = false)
    private String nicename;

    @Email
    @Length(max = 100)
    @Column(name = "user_email", nullable = false)
    private String email;

    @URL
    @Length(max = 100)
    @Column(name = "user_url", nullable = false)
    private String url;

    @Column(name = "user_registered")
    private Timestamp registered;

    @Length(max = 255)
    @Column(name = "user_activation_key", nullable = false)
    private String activationKey;

    @Column(name = "user_status", nullable = false)
    private Integer status;

    @Length(max = 250)
    @Basic(optional = false)
    private String displayName;

}
