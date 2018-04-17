package com.yunjae.bean.regstration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterConfiguration {
    @Bean
    public RouterFunction<?> routes() {
        return route(RequestPredicates.GET("/hi"),
                serverRequest -> ok().body(Flux.just("Hello, world"), String.class));
    }


}
