package com.yunjae.bean.regstration

import com.yunjae.bean.regstration.service.CustomService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@SpringBootApplication
class BeansApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(BeansApplication::class.java)
            .initializers(beans {
                bean<CustomService>()

                bean {
                   ApplicationRunner {
                       println(ref<CustomService>().toString())
                   }
                }

                bean {
                    router {
                        GET("/hi") {
                            val msg = Mono.just("Hello Kotlin")
                            ServerResponse.ok().body(msg)
                        }
                    }
                }

            }).run(*args)
    //runApplication<BeansApplication>(*args)
}

