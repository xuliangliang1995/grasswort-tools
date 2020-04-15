package org.grasswort.jaxb.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname User.java
 * @Description
 * @Date 2020/4/14
 * @blame Java Team
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"age", "name"})
@XmlRootElement(name = "xml")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class User {

    @XmlElement(name = "userName")
    private String name;

    @XmlElement(name = "userAge")
    private Integer age;

    @XmlTransient
    private String ignoreField;

    @XmlJavaTypeAdapter(value = DateAdapter.class)
    private Date time;

    @XmlElementWrapper(name = "scores")
    @XmlElements({
            @XmlElement(name = "score", type = Score.class)
    })
    private List<Score> scores;
}
