package com.example.demo;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;


public class HelloTests extends CamelTestSupport{


    @Test
    void testHello2() throws Exception {

        getMockEndpoint("mock:result").expectedBodiesReceived("Hello World");

        template.sendBody("direct:hello", "Hello World");

        MockEndpoint.assertIsSatisfied(context);
    }



    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:hello")
                        .to("mock:result");
            }
        };
    }
}
