package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "User")
public class User {
    @Id
    String id;
    String username;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
    }

}