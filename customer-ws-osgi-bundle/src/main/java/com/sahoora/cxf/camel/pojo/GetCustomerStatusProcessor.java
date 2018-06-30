
package com.sahoora.cxf.camel.pojo;

import javax.xml.ws.Holder;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetCustomerStatusProcessor implements Processor {
    public static final Logger log = LoggerFactory.getLogger(GetCustomerStatusProcessor.class);

    public void process(Exchange exchng) throws Exception {
        Object[] args =  exchng.getIn().getBody(Object[].class);

        String id = (String) args[0];
        Holder<String> status = (Holder<String>) args[1];
        Holder<String> statusMsg = (Holder<String>) args[2];

        log.debug("Getting status for customer '" + id + "'");

        // This is where you'd actually do the work! Setting
        // the holder values to constants for the sake of brevity.
        //
        status.value = "Offline";
        statusMsg.value = "Going to sleep now!";
        
        exchng.getOut().setBody(new Object[] {status , statusMsg});
    }

}
