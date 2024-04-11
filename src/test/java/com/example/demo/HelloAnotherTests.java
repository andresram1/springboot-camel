package com.example.demo;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CamelSpringBootTest
@MockEndpoints("direct:another")
@SpringBootTest
public class HelloAnotherTests {

    @Autowired
    private ProducerTemplate template;

    @EndpointInject("mock:direct:another")
    private MockEndpoint mock;

    @Test
    void testHello() throws Exception {
        mock.expectedBodiesReceived("Hello");
        template.sendBody("direct:hello", "Hello");
        mock.assertIsSatisfied();
    }

}
