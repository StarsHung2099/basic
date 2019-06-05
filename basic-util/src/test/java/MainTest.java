import com.basic.util.Application;
import org.junit.Test;

/**
 * @description:
 * @name: MainTest
 * @author: Stars Hung
 * @date: 17:04 2019/4/17
 **/
public class MainTest {

    @Test
    public void testMain() {
        Application.main(new String[]{"20190417170555123", "12615041@qq.com", MainTest.class.getResource("/").getPath()});
    }
}
