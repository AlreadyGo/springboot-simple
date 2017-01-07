package tk.springboot.simple.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/6 9:56
 */
@Configuration
public class GeneralConfig {
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        return new CommonsMultipartResolver();
    }
}
