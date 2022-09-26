package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${info.uri}")
    private String infoUri;

    @GetMapping(value = "/config/getUri")
    public String getUri(){
        return  infoUri;
    }

}
