import com.basic.util.constants.Constants;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @name: MD5GeneratorTest
 * @author: Stars Hung
 * @date: 11:12 2019/4/15
 **/
public class MD5GeneratorTest {

    String partnerNo;
    String partnerEmail;

    @Before
    public void before(){
        partnerNo = "20190415112355999";
        partnerEmail = "12615041@qq.com";
    }

    @Test
    public void testGenerator() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(Constants.MD5);
        md.update(partnerNo.concat(partnerEmail).getBytes());
        System.out.println(new BigInteger(1, md.digest()).toString(16).length());
    }

    @Test
    public void testDigestUtils(){

    }

}
