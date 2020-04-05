package org.grasswort.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.grasswort.xstream.model.Person;

/**
 * @author xuliangliang
 * @Classname PersonXStream.java
 * @Description
 * @Date 2020/4/4
 * @blame Java Team
 */
public class PersonXStreamTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("小明");
        person.setAge(18);

        // StaxDriver使用SAX解析器(可从Java6)，一个快速的XML解析器。
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(person);
        System.out.println(XmlFormatUtil.formatXml(xml));

        Person person1 = (Person)xStream.fromXML(xml);
        System.out.println(person1);
    }
}
