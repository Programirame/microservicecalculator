package org.programirame;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/multiply")
@RestController
public class MultiplicationController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Integer> addTwoNumbers(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y) {
        return new ResponseEntity<>(x*y, HttpStatus.OK);
    }
}
