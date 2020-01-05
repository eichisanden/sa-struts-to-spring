package tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usr {
    @Id
    public Integer id;

    public String name;

    public Usr(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
