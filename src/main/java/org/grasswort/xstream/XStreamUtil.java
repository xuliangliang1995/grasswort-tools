package org.grasswort.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;

import java.io.Writer;

/**
 * @author xuliangliang
 * @Classname XStreamUtil.java
 * @Description
 * @Date 2020/4/9
 * @blame Java Team
 */
public class XStreamUtil {
    /**
     * 对象转 xml
     * @param object
     * @return
     */
    public static final String toXml(Object object) {
        return XStreamSingletonHolder.XSTREAM.toXML(object);
    }

    /**
     * xml 转对象
     * @param xml
     * @return
     */
    public static final Object fromXml(String xml) {
        return XStreamSingletonHolder.XSTREAM.fromXML(xml);
    }


    private static final class XStreamSingletonHolder {
        static final XStream XSTREAM;
        static {
            // XStream 解析 Java 对象为 xml 时 _ 会被解析成 __ ，加上这个 nameCoder 就可以解决
            final NameCoder nameCoder = new XmlFriendlyNameCoder("_-", "_");
            XSTREAM = new XStream(new Xpp3DomDriver() {
                @Override
                public HierarchicalStreamWriter createWriter(Writer out) {
                    final String CDATA_PREFIX = "<![CDATA[", CDATA_SUFFIX = "]]>";
                    return new PrettyPrintWriter(out, nameCoder) {
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
            XSTREAM.autodetectAnnotations(true);
            XSTREAM.ignoreUnknownElements();
        }

    }

}
