package org.lintaspena.elearning.security

import org.lintaspena.elearning.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@EnableWebSecurity
open class WebAndApiSecurityConfig {

    @Autowired
    private lateinit var userDetailsServiceImpl: UserDetailsServiceImpl

    @Configuration
    @Order(1)
    open class ApiSecurityConfig : WebSecurityConfigurerAdapter() {

        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http.antMatcher("/**")
                    .httpBasic()
        }
    }

    @Configuration
    @Order(2)
    open class WebSecurityConfig : WebSecurityConfigurerAdapter() {

        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http.authorizeRequests()
                    .antMatchers("/admin/**","/public/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .failureUrl("/")
                    .loginPage("/")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutRequestMatcher(AntPathRequestMatcher("/"))
                    .logoutSuccessUrl("/")
                    .permitAll()
        }
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        //Create BCryptPassword encoder
        val encoder = BCryptPasswordEncoder()

        //add components
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder)
    }
}