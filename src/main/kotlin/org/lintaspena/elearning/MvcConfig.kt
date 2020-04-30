package org.lintaspena.elearning

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class MvcConfig : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("public/fragments/beranda")
        registry.addViewController("/login").setViewName("public/fragments/login")
        registry.addViewController("/akun").setViewName("public/fragments/akun")
    }

}