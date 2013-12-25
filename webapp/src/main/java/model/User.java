package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 22.12.13
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="USER")
public class User implements Serializable{

    private int id;
    private String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
