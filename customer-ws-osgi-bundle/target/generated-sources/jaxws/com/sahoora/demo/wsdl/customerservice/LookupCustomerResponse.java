
package com.sahoora.demo.wsdl.customerservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.sahoora.demo.customer.Customer;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ret" type="{http://www.sahoora.com/demo/customer}Customer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ret"
})
@XmlRootElement(name = "lookupCustomerResponse")
public class LookupCustomerResponse {

    @XmlElement(required = true)
    protected Customer ret;

    /**
     * Gets the value of the ret property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getRet() {
        return ret;
    }

    /**
     * Sets the value of the ret property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setRet(Customer value) {
        this.ret = value;
    }

}
