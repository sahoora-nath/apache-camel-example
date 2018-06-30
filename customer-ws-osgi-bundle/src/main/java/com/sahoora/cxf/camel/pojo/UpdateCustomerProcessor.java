
package com.sahoora.cxf.camel.pojo;

import com.sahoora.demo.customer.Customer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UpdateCustomerProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(UpdateCustomerProcessor.class);

    public void process(Exchange exchng) throws Exception {
        Customer c = (Customer) exchng.getIn().getBody(Object[].class)[0];

        log.debug("Updating customer " + c.getFirstName() + " " + c.getLastName());

        // No response paramters (this is a void function) so we set the out message.
        //
        exchng.getOut().setBody(new Object[] {});
    }

}
