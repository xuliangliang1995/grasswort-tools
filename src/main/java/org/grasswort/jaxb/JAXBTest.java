package org.grasswort.jaxb;

import com.sun.xml.internal.xsom.util.DomAnnotationParserFactory;
import org.grasswort.jaxb.model.Score;
import org.grasswort.jaxb.model.User;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname JAXBTest.java
 * @Description
 * @Date 2020/4/14
 * @blame Java Team
 */
public class JAXBTest {

    public static void main(String[] args) throws JAXBException {
        User user = new User();
        user.setName("小明");
        user.setAge(18);
        user.setIgnoreField("ignore");
        user.setTime(new Date());

        List<Score> scores = new ArrayList<>();
        Score score1 = new Score();
        score1.setItem("语文");
        score1.setScore(99);

        Score score2 = new Score();
        score2.setItem("数学");
        score2.setScore(100);

        scores.add(score1);
        scores.add(score2);
        user.setScores(scores);

        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(user, stringWriter);
        String xml = stringWriter.toString();
        System.out.println(xml);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        User user1 = (User) unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(user1);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            saxParserFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
            saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            Source source = new SAXSource(saxParserFactory.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));
            User user2 = (User)unmarshaller.unmarshal(source);
            System.out.println(user2);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
