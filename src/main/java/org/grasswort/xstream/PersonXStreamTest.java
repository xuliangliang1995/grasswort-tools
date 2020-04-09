package org.grasswort.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.XppDomDriver;
import org.grasswort.xstream.model.Person;

import java.io.Writer;

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
        person.setName("小明>");
        person.setAge(18);

        XStream xStream = new XStream(new Xpp3DomDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                final String CDATA_PREFIX = "<![CDATA[", CDATA_SUFFIX = "]]>";
                return new PrettyPrintWriter(out) {
                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (text.startsWith(CDATA_PREFIX) && text.endsWith(CDATA_SUFFIX)) {
                            writer.write(text);
                        } else {
                            writer.write(CDATA_PREFIX + text + CDATA_SUFFIX);
                        }
                    }
                };
            }
        });
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(person);
        System.out.println(XmlFormatUtil.formatXml(xml));

        Person person1 = (Person)xStream.fromXML(xml);
        System.out.println(person1);

        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><org.grasswort.xstream.model.Person>\n" +
                "  <name><![CDATA[小明]]></name>\n" +
                "  <age>18</age>\n" +
                "</org.grasswort.xstream.model.Person>";
        Person person2 = (Person)xStream.fromXML(xml2);
        System.out.println(person2);

    }
}
