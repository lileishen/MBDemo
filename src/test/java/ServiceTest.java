import com.mb.Service.ServiceImpl.UserServiceImpl;
import com.mb.Service.UserService;
import com.mb.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author nono
 * @Package PACKAGE_NAME
 * @ClassName ServiceTest.java
 * @Description TODO
 * @createTime 2020年08月20日 23:16:00
 */
public class ServiceTest {

    @Test
    public void test(){
        UserService userService =new UserServiceImpl();
        List<User> users = null;
        try {
            users = userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.forEach(System.out::print);
    }
}
