package org.programirame;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/simple")
@RestController
public class OperationsController {

    @RequestMapping(value = "/multiply-all", method = RequestMethod.GET)
    public ResponseEntity<Integer> multiplyAllNumbers(@RequestParam(value = "all") String all) {
        String[] allNumbers = all.split(",");
        int total = 0;
        if(allNumbers.length > 0) {
            total = Integer.parseInt(allNumbers[0]);
            for(int i = 1; i<allNumbers.length; i++) {
                total *= Integer.parseInt(allNumbers[i]);
            }
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
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
