//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.26 at 08:50:37 PM EST 
//


package com.ez_konnect.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Technical"/&gt;
 *     &lt;enumeration value="Functional"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ErrorTypeEnum")
@XmlEnum
public enum ErrorTypeEnum {

    @XmlEnumValue("Technical")
    TECHNICAL("Technical"),
    @XmlEnumValue("Functional")
    FUNCTIONAL("Functional");
    private final String value;

    ErrorTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorTypeEnum fromValue(String v) {
        for (ErrorTypeEnum c: ErrorTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}