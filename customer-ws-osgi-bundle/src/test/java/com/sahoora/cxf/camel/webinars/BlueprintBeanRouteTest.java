package com.sahoora.cxf.camel.webinars;

import com.sahoora.demo.customer.Customer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.component.direct.DirectEndpoint;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BlueprintBeanRouteTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint-bean.xml";
    }

    @Test
    public void testTimerRoute() throws Exception {
        // the route is timer based, so every 5th second a message is send
        // we should then expect at least one message
        getMockEndpoint("mock:result").expectedMinimumMessageCount(1);

        // assert expectations
        assertMockEndpointsSatisfied();
    }

    @Override
    protected Properties useOverridePropertiesWithPropertiesComponent() {
        Properties extra = new Properties();
        extra.put("cxfEndpoint", "direct:cxfws");
        return extra;
    }

    /**
     * Test with real endpoints
     *
     * @throws Exception
     */
    @Test
    public void testCxfRealEndpointRoute() throws Exception {

        DirectEndpoint testEndpoint = context.getEndpoint("direct:cxfws", DirectEndpoint.class);

        Exchange reply = template.request("direct:cxfws", new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                final List<String> params = new ArrayList<>();
                params.add("1234");
                exchange.getIn().setBody(params);
                exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "lookupCustomer");
            }
        });

        Object[] replyBody = (Object[]) reply.getOut().getBody();
        if (replyBody[0] instanceof Customer) {
            Customer c = (Customer) replyBody[0];
            assertEquals("1234", c.getId());
        } else {
            assertFalse(true);
        }

        assertMockEndpointsSatisfied();
    }

    /**
     * Test with mock endpoints
     *
     * @throws Exception
     */
    @Test
    public void testCxfMockEndpoint() throws Exception {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:cxf:bean:customer-ws");
        mockEndpoint.expectedMessageCount(1);

        mockEndpoint.whenAnyExchangeReceived(exchange -> {
            final List<String> params = new ArrayList<>();
            params.add("1234");
            exchange.getIn().setBody(params);
            exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "lookupCustomer");
        });

        //send message
        template.request(mockEndpoint, new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

            }
        });
        assertMockEndpointsSatisfied();
    }

}
