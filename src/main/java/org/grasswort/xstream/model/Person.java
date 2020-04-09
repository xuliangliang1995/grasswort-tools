package org.grasswort.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author xuliangliang
 * @Classname Person.java
 * @Description
 * @Date 2020/4/4
 * @blame Java Team
 */
@Data
@XStreamAlias("xml")
public class Person {

    private String name;

    private Integer age;

}
