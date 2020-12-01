import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDao {
    @Test
    public void TestEmpDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // EmpService empService = (EmpService) context.getBean("empService");
        //context.close();
        EmpService userService = (EmpService) context.getBean("empService");
        Emp emp = userService.login("1");
        System.out.println(emp);
    }
}
