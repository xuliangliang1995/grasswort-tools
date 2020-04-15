package org.grasswort.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMCDATA;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname Dom4jTest.java
 * @Description
 * @Date 2020/4/15
 * @blame Java Team
 */
public class Dom4jTest {

    public static void main(String[] args) {
        //Document document = readXml();
        Document document = parseXmlText();
        Element element = document.getRootElement();

        Element newNode = element.addElement("newNode");
        newNode.add(new DOMCDATA("newNodeValue"));

        List<Element> elements = element.elements();
        elements.stream().forEach(e -> System.out.println(e.getName() + ":" + e.getStringValue()));

        writeToNewXmlFile(document);


    }

    /**
     * 读取 xml 文档
     * @return
     */
    private static Document readXml() {
        SAXReader saxReader = new SAXReader();
        try {
            return saxReader.read(new File("src\\main\\resources\\test.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void writeToNewXmlFile(Document document)  {
        FileOutputStream fileOutputStream = null;
        XMLWriter xmlWriter = null;
        try {
            String filePath = "src\\main\\resources\\test2.xml";
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fileOutputStream = new FileOutputStream("src\\main\\resources\\test2.xml");
            xmlWriter = new XMLWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
            xmlWriter.write(document);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public static Document parseXmlText() {
        String xml = "<xml>\n" +
                "    <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "    <attach><![CDATA[支付测试]]></attach>\n" +
                "    <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "    <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "    <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "    <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "    <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "    <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "    <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "    <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "    <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "    <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "    <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "    <total_fee>1</total_fee>\n" +
                "    <coupon_fee><![CDATA[10]]></coupon_fee>\n" +
                "    <coupon_count><![CDATA[1]]></coupon_count>\n" +
                "    <coupon_type><![CDATA[CASH]]></coupon_type>\n" +
                "    <coupon_id><![CDATA[10000]]></coupon_id>\n" +
                "    <coupon_fee><![CDATA[100]]></coupon_fee>\n" +
                "    <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "    <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";
        try {
            return DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
