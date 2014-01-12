package doco.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DOCO_USUARIOS")
public class Usuario implements Serializable {

    private String userId;
    private String password;

    public Usuario() {
    }

    public Usuario(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Id
    @Column(name = "C_USUARIO_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    @Column(name = "A_PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
