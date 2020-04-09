package org.grasswort.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.grasswort.xstream.model.Student;

/**
 * @author xuliangliang
 * @Classname StudentXStreamTest.java
 * @Description
 * @Date 2020/4/5
 * @blame Java Team
 */
public class StudentXStreamTest {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("小明");

        Student.Note note1 = new Student.Note();
        note1.setTitle("title1");
        note1.setDescription("desc1");
        student.addNote(note1);

        Student.Note note2 = new Student.Note();
        note2.setTitle("title2");
        note2.setDescription("desc2");
        student.addNote(note2);

        // StaxDriver使用SAX解析器(可从Java6)，一个快速的XML解析器。
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(student);
        System.out.println(XmlFormatUtil.formatXml(xml));

        Student student1 = (Student) xStream.fromXML(xml);
        System.out.println(student1);

    }
}
