package fr.smeal.subscription.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MailUtilTest {
    @Test
    public void sendMailTest() {
        MailUtil.sendMail("wangyang1712@gmail.com", "test", "This is a test");
    }
}

