package org.programirame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/simple")
@RestController
public class OperationsController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/multiply-all", method = RequestMethod.GET)
    public List<ServiceInstance> multiplyAllNumbers(@RequestParam(value = "all") String all) {

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("addition");

        for(ServiceInstance instance : serviceInstances) {
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
        }

        String[] allNumbers = all.split(",");
        int total = 0;
        if(allNumbers.length > 0) {
            total = Integer.parseInt(allNumbers[0]);
            for(int i = 1; i<allNumbers.length; i++) {
                total *= Integer.parseInt(allNumbers[i]);
            }
        }
        return discoveryClient.getInstances("addition");
    }

    @RequestMapping(value = "/add-all", method = RequestMethod.GET)
    public ResponseEntity<Integer> addAllNumbers(@RequestParam(value = "all") String all) {
        String[] allNumbers = all.split(",");
        int total = 0;
        if(allNumbers.length > 0) {
            total = Integer.parseInt(allNumbers[0]);
            for(int i = 1; i<allNumbers.length; i++) {
                total += Integer.parseInt(allNumbers[i]);
            }
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
