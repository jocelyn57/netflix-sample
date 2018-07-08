package lu.cgi.sample.netflix.service.demo;

import lu.cgi.sample.netflix.service.demo.bean.DemoRequest;
import lu.cgi.sample.netflix.service.demo.bean.DemoResponse;
import lu.cgi.sample.netflix.service.demo.bean.DemoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class DemoService {

    @Value("${spring.application.name}")
    private String applicationName;


    private DemoProperties demoProperties;


    private RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(DemoService.class.getName());




    public DemoService(@Autowired DemoProperties demoProperties,@Autowired RestTemplate restTemplate) {
        this.demoProperties = demoProperties;
        this.restTemplate = restTemplate;
    }

    public DemoResponse call(DemoRequest request) {
        if (request.getDeep() > request.getStep()) {
            return callBackEnd(request);
        }
        else {
            LOG.info("last call deep:"+request.getStep());
            return new DemoResponse(DemoStatus.SUCCESS, "Hello" + request.getName() +" from "+applicationName);
        }
    }

    public DemoResponse callBackEnd(DemoRequest request) {
        LOG.info("prepare callback call deep:"+request.getStep());
        String uri="http://"+demoProperties.getBackendInfo().getServiceName()+"/demo/call";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        DemoResponse result = restTemplate.postForObject(uri, request.next(), DemoResponse.class);
        return result;



    }

}
