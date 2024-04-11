package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:hello")
                .log("Camel body: ${body}")
                .to("direct:another");

        from("direct:another")
                .log("Camel body in another call: ${body}");
    }
}
