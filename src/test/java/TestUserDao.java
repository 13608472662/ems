import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    @Test
    public void TestUserDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // EmpService empService = (EmpService) context.getBean("empService");
        //context.close();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login("cc");
        System.out.println(user);
    }
}
