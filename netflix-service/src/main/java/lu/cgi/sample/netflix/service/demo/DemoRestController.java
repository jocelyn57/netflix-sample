package lu.cgi.sample.netflix.service.demo;

import lu.cgi.sample.netflix.service.demo.bean.DemoRequest;
import lu.cgi.sample.netflix.service.demo.bean.DemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
public class DemoRestController {


    private DemoService service;

    public DemoRestController(@Autowired DemoService service) {
        this.service = service;
    }

    @PostMapping(value = "call")
    @ResponseBody
    public DemoResponse call(@Valid @RequestBody DemoRequest request ) {
       return service.call(request);
    }

}
