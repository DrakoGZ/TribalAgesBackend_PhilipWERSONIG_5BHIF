package philip.wersonig.backend.tribalages.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConf implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://localhost:4200")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("authorization" , "contentType" , "Origin", "Content-Type", "X-Auth-Token")
                .exposedHeaders("Authorization");
    }

    /*public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://localhost:4200", "http://localhost:4200")
                        .allowedMethods("GET", "POST","OPTIONS")
                        .allowedHeaders("authorization" , "contentType" , "Origin", "Content-Type", "X-Auth-Token")
                        .exposedHeaders("Authorization");
            }
        };
    }*/

}
