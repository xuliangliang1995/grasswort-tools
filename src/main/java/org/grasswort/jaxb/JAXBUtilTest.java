package org.grasswort.jaxb;

import org.grasswort.jaxb.model.User;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Objects;

/**
 * @author xuliangliang
 * @Classname JAXBUtilTest.java
 * @Description
 * @Date 2020/4/23
 * @blame Java Team
 */
public class JAXBUtilTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("grasswort");
        user.setAge(18);
        String xml = JAXBUtil.marshal(user);

        User newUser = JAXBUtil.unmarshal(xml, User.class);
        System.out.println(newUser != null && Objects.equals(newUser.getAge(), user.getAge()) && Objects.equals(newUser.getName(), user.getName()));

        Reader reader = new StringReader(xml);
        JAXBUtil.unmarshal(reader, User.class);

    }
}
