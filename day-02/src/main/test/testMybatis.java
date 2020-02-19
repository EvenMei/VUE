import com.meiyukai.dao.UserDao;
import com.meiyukai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class testMybatis {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    public void testFindAll(){
        List<User> users  = userDao.findAll();
        for(User user: users){
            System.out.println("user:  "  + user);
        }

    }


    @Test
    public void testFindOne(){
        User user = userDao.findUserById(4);
        System.out.println("user:  " + user);
    }

    @Test
    public void testUpdate(){
        User user = userDao.findUserById(4);
        System.out.println("before update :  " + user);
        user.setSex("female");
        userDao.updateUser(user);
        System.out.println("update user :  "+userDao.findUserById(4));
    }


}
