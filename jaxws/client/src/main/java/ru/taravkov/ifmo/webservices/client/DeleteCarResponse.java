
package ru.taravkov.ifmo.webservices.client;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for deleteCarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteCarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.ws.webservices.ifmo.taravkov.ru/}opStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCarResponse", propOrder = {
    "_return"
})
public class DeleteCarResponse {

    @XmlElement(name = "return")
    @XmlSchemaType(name = "string")
    protected OpStatus _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link OpStatus }
     *     
     */
    public OpStatus getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpStatus }
     *     
     */
    public void setReturn(OpStatus value) {
        this._return = value;
    }

}
