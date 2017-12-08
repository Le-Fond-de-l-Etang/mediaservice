package client;

import io.spring.guides.gs_producing_web_service.GetMusicsRequest;
import io.spring.guides.gs_producing_web_service.MultipleMusicResponse;
import io.spring.guides.gs_producing_web_service.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXBContext;

public class RunClient {

        public static void main(String[] args) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
            System.out.println(context.getBeanDefinitionCount());
            MusicClient client = context.getBean(MusicClient.class);

            GetMusicsRequest request = new GetMusicsRequest();

            MultipleMusicResponse resp = client.getBeer(request);
            System.out.println("response: " + resp);
        }

    @Bean
    public JAXBContext jaxbContext() throws Exception {
        ObjectFactory factory = new ObjectFactory();
        return JAXBContext.newInstance(factory.getClass());
    }

    }

