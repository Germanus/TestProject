package my;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

       public int sum(int i, int j){

           //jdbcTemplate.queryForList();
           return i+j;
       }

}
