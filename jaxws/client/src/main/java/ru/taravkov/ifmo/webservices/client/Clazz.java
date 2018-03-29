
package ru.taravkov.ifmo.webservices.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clazz.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="clazz">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUBCOMPACT"/>
 *     &lt;enumeration value="COMPACT"/>
 *     &lt;enumeration value="CROSSOVER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "clazz")
@XmlEnum
public enum Clazz {

    SUBCOMPACT,
    COMPACT,
    CROSSOVER;

    public String value() {
        return name();
    }

    public static Clazz fromValue(String v) {
        return valueOf(v);
    }

}
