package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class SoapClientConfig {



    @Bean
    public MusicClient getMusicClient(){
        MusicClient musicClient = new MusicClient();
        musicClient.setDefaultUri("http://localhost:8080/ws/*");
        return musicClient;
    }

}
