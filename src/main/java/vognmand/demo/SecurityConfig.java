package vognmand.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select brugernavn,password, aktiv from bruger where brugernavn=?")
                .authoritiesByUsernameQuery(
                        "select brugernavn, rolle from bruger where brugernavn=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/", "/mainPage").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/","/hovedSide", "/ansatInfo", "/opgaveList")
                .access("hasAnyAuthority('ROLE_CHAUFFØR','ROLE_ADMIN','ROLE_KONTOR')")
                .antMatchers("opgaveList/opretOpgave","opgaveList/redigerOpgave/{id}", "opgaveList/sletOpgave/{id}")
                .access("hasAuthority('ROLE_KONTOR')")
                .antMatchers("/admin/","/ansatInfo/opretAnsat",
                        "/ansatInfo/redigerAnsat/{id}","/kontorInfo/ansatSlet/{id}","/ansatInfo/ansatSlet/{id}")
                .access("hasAuthority('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("brugernavn").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();

    }



    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}