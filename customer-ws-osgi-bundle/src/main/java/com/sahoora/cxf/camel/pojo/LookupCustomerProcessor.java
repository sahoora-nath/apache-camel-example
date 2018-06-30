
package com.sahoora.cxf.camel.pojo;

import com.sahoora.cxf.camel.error.ValidationException;
import com.sahoora.demo.customer.Customer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LookupCustomerProcessor implements Processor {

    public static final Logger log = LoggerFactory.getLogger(LookupCustomerProcessor.class);

    public void process(Exchange exchng) throws ValidationException {

        Object[] args = exchng.getIn().getBody(Object[].class);
        String customerId = (String) args[0];

        if (customerId == null || customerId.equals("")) {
            throw new ValidationException("Invalid Customer ID");
        }

        Customer c = new Customer();
        c.setFirstName("Ade");
        c.setLastName("Trenaman");
        c.setId(customerId);
        c.setPhoneNumber("+44-131-01234567");

        exchng.getOut().setBody(new Object[] {c});
    }
}
