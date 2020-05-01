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
        registry.addViewController("/profile").setViewName("public/fragments/profile")
        registry.addViewController("/pembelian").setViewName("public/fragments/pembelian")
        registry.addViewController("/kelassaya").setViewName("public/fragments/kelassaya")
    }

}