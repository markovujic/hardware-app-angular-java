package hr.tvz.vujic.hardwareapp.security.login;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "authority_name", length = 50, nullable = false)
    private String name;

    @ManyToMany(targetEntity = User.class, mappedBy = "authorities")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
