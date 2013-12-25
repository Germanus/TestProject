package my;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 15.12.13
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class Service {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;


    public int sum(int i, int j) {

        //jdbcTemplate.queryForList();
        return i + j;
    }

    public void find() {
        User u = entityManager.find(User.class, 1);
        int i = 0;
    }

    public void insertUser(){
        User user = new User();
        user.setFirstName("IlYa");
        entityManager.persist(user);

    }

}
