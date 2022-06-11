import com.cpy.controller.UsersController;
import com.cpy.pojo.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void ma() {
        Users users = new Users(1,"abc",23);
        UsersController usersController = new UsersController();
        usersController.insert(users);
    }

    @Test
    public void ma2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersController usersController = (UsersController) ac.getBean("uController");
        usersController.insert(new Users(1,"abc",23));
    }

}
