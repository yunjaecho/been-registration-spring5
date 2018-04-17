package com.yunjae.bean.regstration.configuration

import com.yunjae.bean.regstration.service.CustomService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val customService: CustomService) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        println(customService.toString())
    }
}