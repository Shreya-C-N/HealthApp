package com.valtech.health.app.config;

import org.springframework.context.annotation.Bean; 
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;



@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {

	
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http.headers().frameOptions().disable();
//
//        http.authorizeRequests().antMatchers("/register").anonymous().antMatchers("/user").hasAnyRole("USER")
//                .antMatchers("/register", "/login", "/logout", "/resetUsers").permitAll().and().httpBasic();
//
//        return http.build();
        http.csrf().disable().authorizeRequests()
        .antMatchers("/views/**").permitAll()
        .antMatchers("/","/login","/aboutus","/register","/home").permitAll()  //dashboard , Aboutus page will be permit to all user
        .antMatchers("/admindashboard/**").hasAnyRole("ADMIN") //Only admin user can login
        .antMatchers("/dashboard","/dashboard/**").hasAnyRole("NURSE") //Only normal user can login
        .antMatchers("/doctordashboard","/doctordashboard/**").hasAnyRole("DOCTOR")
        .anyRequest().authenticated() //Rest of all request need authentication
                .and()
                .formLogin()
        //.loginPage("/login")  //Loginform all can access ..
        .defaultSuccessUrl("/dashboard")
        .failureUrl("/login?error")
        .permitAll()
        .and()
        .logout()
        .permitAll();
        return http.build();
    }
	
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//
//		return http.build();
//	}

	@Bean
	   public BCryptPasswordEncoder passwordEncoder() {
	      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	      return bCryptPasswordEncoder;
	}
	  
	

	@Bean
    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {



       InMemoryUserDetailsManager udm = new InMemoryUserDetailsManager();



       udm.createUser(User.withUsername("scott").password(passwordEncoder.encode("tiger")).roles("USER").build());
        udm.createUser(
                User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build());
        return udm;

	}
}




//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(jsr250Enabled=true,securedEnabled=true,prePostEnabled=true)
//public class WebSecurityConfig{
//
//
//
//   @Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{  // (2)
////     http
////       .authorizeRequests()
////         .antMatchers("/", "/home").permitAll() // (3)
////         .anyRequest().authenticated() // (4)
//         http.csrf().disable();
//         
//        http.headers().frameOptions().disable();
//        http.authorizeRequests()
//        .antMatchers("/login","/register").hasAnyRole("DOCTOR","NURSE")    
//        .antMatchers("/patientdetails").authenticated()
//        .antMatchers("/updatedl/**").authenticated()
//        .antMatchers("/updateddllist").authenticated()
//        .antMatchers("/dllist/**").authenticated()
//        .antMatchers("/police/**").authenticated()
//        .antMatchers("/accessDenied").authenticated()
//        .antMatchers("/allowAccess/**").authenticated()
//        .antMatchers("/vehicleType/**").authenticated()
//        .antMatchers("/register").authenticated()
//        .anyRequest().permitAll()
//         .and()
//      .formLogin()
////      .loginPage("/admin")// (5)
//        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true")// (5)
//        .permitAll()
//        .and()
//        .httpBasic();
//     http.logout() // (6)
//       .permitAll()
//       .and()
//     .httpBasic(); // (7)
//        return http.build();
//}
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    
//    @Bean
//    public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
//        
//        InMemoryUserDetailsManager udm =new InMemoryUserDetailsManager();
//    
//        
////        udm.createUser(User.withUsername("scott").password(passwordEncoder.encode("tiger")).roles("USER").build());
//        udm.createUser(User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN","USER").build());
//
//
//
//       return udm;
//        
//    }
//    
//}
