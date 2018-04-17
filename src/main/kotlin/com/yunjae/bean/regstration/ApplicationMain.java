package com.yunjae.bean.regstration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ApplicationMain.class)
                .initializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
                    ctx.registerBean(ApplicationRunner.class, () ->
                        args1 -> System.out.println("aaaaa")
                    );
                    ctx.registerBean(RouterFunction.class, () ->
                        route(GET("/hi"), req -> ok().body(Mono.just("Hello Body"), String.class))
                    );

                }).run(args);
    }
}
