package org.grasswort.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.grasswort.xstream.model.Animal;

/**
 * @author xuliangliang
 * @Classname AnimalXStreamTest.java
 * @Description
 * @Date 2020/4/5
 * @blame Java Team
 */
public class AnimalXStreamTest {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setName("狗");
        animal.setDesc("我是一只小狗");

        XStream xStream = new XStream(new StaxDriver());
        //  这一步很重要
        xStream.processAnnotations(Animal.class);

        String xml = xStream.toXML(animal);
        System.out.println(XmlFormatUtil.formatXml(xml));


    }
}
