package client;

import io.spring.guides.gs_producing_web_service.GetMusicsRequest;
import io.spring.guides.gs_producing_web_service.MultipleMusicResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MusicClient extends WebServiceGatewaySupport {

    public MultipleMusicResponse getBeer(GetMusicsRequest request){
        return (MultipleMusicResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
