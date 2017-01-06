package tk.springboot.simple.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2017/1/6 9:56
 * @jdk v1.7
 * @tomcat v7.0
 */
@Configuration
public class GeneralConfig {
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        return new CommonsMultipartResolver();
    }
}
