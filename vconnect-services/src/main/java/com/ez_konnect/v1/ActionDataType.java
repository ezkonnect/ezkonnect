//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.26 at 08:50:37 PM EST 
//


package com.ez_konnect.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Definition for Action Data
 *             
 * 
 * <p>Java class for ActionDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestGlobalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="UserAction" type="{http://ez-konnect.com/v1}UserActionType"/&gt;
 *         &lt;element name="UserLoginId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserName" type="{http://ez-konnect.com/v1}NameType" minOccurs="0"/&gt;
 *         &lt;element name="UserIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserRegion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionDataType", propOrder = {
    "requestGlobalID",
    "userAction",
    "userLoginId",
    "userName",
    "userIP",
    "userRegion",
    "userDevice"
})
public class ActionDataType {

    @XmlElement(name = "RequestGlobalID", required = true)
    protected String requestGlobalID;
    @XmlElement(name = "UserAction", required = true)
    protected UserActionType userAction;
    @XmlElement(name = "UserLoginId")
    protected String userLoginId;
    @XmlElement(name = "UserName")
    protected NameType userName;
    @XmlElement(name = "UserIP")
    protected String userIP;
    @XmlElement(name = "UserRegion")
    protected String userRegion;
    @XmlElement(name = "UserDevice")
    protected String userDevice;

    /**
     * Gets the value of the requestGlobalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestGlobalID() {
        return requestGlobalID;
    }

    /**
     * Sets the value of the requestGlobalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestGlobalID(String value) {
        this.requestGlobalID = value;
    }

    /**
     * Gets the value of the userAction property.
     * 
     * @return
     *     possible object is
     *     {@link UserActionType }
     *     
     */
    public UserActionType getUserAction() {
        return userAction;
    }

    /**
     * Sets the value of the userAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserActionType }
     *     
     */
    public void setUserAction(UserActionType value) {
        this.userAction = value;
    }

    /**
     * Gets the value of the userLoginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLoginId() {
        return userLoginId;
    }

    /**
     * Sets the value of the userLoginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLoginId(String value) {
        this.userLoginId = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setUserName(NameType value) {
        this.userName = value;
    }

    /**
     * Gets the value of the userIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIP() {
        return userIP;
    }

    /**
     * Sets the value of the userIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIP(String value) {
        this.userIP = value;
    }

    /**
     * Gets the value of the userRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRegion() {
        return userRegion;
    }

    /**
     * Sets the value of the userRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRegion(String value) {
        this.userRegion = value;
    }

    /**
     * Gets the value of the userDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDevice() {
        return userDevice;
    }

    /**
     * Sets the value of the userDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDevice(String value) {
        this.userDevice = value;
    }

}
