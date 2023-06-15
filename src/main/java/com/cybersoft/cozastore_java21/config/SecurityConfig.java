package com.cybersoft.cozastore_java21.config;

import com.cybersoft.cozastore_java21.filter.JwtFilter;
import com.cybersoft.cozastore_java21.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //  Khai báo chuẩn mã hoá Bcrypt và lưu trữ trên IOC
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails admin = User.withUsername("save")
//                .password(passwordEncoder().encode("123456"))
//                .roles("ADMIN","SAVE").build();
//        UserDetails user = User.withUsername("delete")
//                .password(passwordEncoder().encode("123456"))
//                .roles("DELETE").build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }

//  Baitap: /admin/save : ADMIN hoặc SAVE
//          /admin/delete: DELETE

    //      Đây là filter dùng để custom rule liên quan tới link hoặc
//      cấu hình của security
//      Java 8 và 11 : antMatchers
    @Bean // Ghi đề lại cái trang cấu hình mặc đinh của security
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable() // Tắt cấu hình liên quan đến tấn công CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // khai báo không sử dụng session trong project
                .and()
                .authorizeHttpRequests()   // Quy định lại các rule liên quan tới chứng thực cho link được gọi
                .antMatchers("/signin", "/signup").permitAll()  // cho phép vào luôn ko cần chứng thực
                .anyRequest().authenticated() // Tất cả các link còn lại cần phải chứng thực
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)//add filter cua minh truoc filtersecurity
                .build();
    }

    @Autowired
    private CustomAuthenProvider customAuthenProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//                //Khai báo sử dụng custom user detail service
//                .userDetailsService(customUserDetailService)
//                //khai báo chuẩn mã hoá password mà custom user
//                //detail service đang sử dụng
//                .passwordEncoder(passwordEncoder())
                // khai báo sử dung customauthenprovider
                .authenticationProvider(customAuthenProvider)
                .build();
    }
}
