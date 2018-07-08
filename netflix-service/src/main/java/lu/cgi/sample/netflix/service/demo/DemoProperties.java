package lu.cgi.sample.netflix.service.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="demo")
public class DemoProperties {




    private Integer serviceNumber;

    private BackendInfo backendInfo = new BackendInfo();


    public Integer getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Integer serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public BackendInfo getBackendInfo() {
        return backendInfo;
    }

    public void setBackendInfo(BackendInfo backendInfo) {
        this.backendInfo = backendInfo;
    }


    public class BackendInfo {

        private String serviceName;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
    }
}
