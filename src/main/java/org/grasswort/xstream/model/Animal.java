package org.grasswort.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author xuliangliang
 * @Classname Animal.java
 * @Description
 * @Date 2020/4/5
 * @blame Java Team
 */
@Data
@XStreamAlias("animal")
public class Animal {

    @XStreamAlias("animalName")
    @XStreamAsAttribute
    private String name;

    @XStreamAlias("desc")
    private String desc;

}
