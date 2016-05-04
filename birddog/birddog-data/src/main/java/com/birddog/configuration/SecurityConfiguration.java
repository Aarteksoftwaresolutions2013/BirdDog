package com.birddog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

/**
 * @author Aartek, 04/03/2015, SecurityConfiguration file for url and password encoder and role base
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Injects the instance of {@link UserDetailsService}. This is the default Service of Security
     */
    @Autowired
    @Qualifier(IConstant.USER_DETAIL_SERVICE)
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(ConstantURL.WELCOME_URL_PATTERN).permitAll().and().formLogin()
                        .loginPage(ConstantURL.LOGIN_URL).failureUrl(ConstantURL.LOGIN_FAILIOUR)
                        .usernameParameter(IConstant.EMAIL).usernameParameter(IConstant.USER_NAME).passwordParameter(IConstant.PASSWORD)
                        .defaultSuccessUrl(ConstantURL.WELCOME_URL).and().logout()
                        .logoutSuccessUrl(ConstantURL.LOGOUT_URL).and().csrf().disable().exceptionHandling()
                        .accessDeniedPage(ConstantURL.ERROR_URL);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
