package hu.flowacademy.demo.controller;

import hu.flowacademy.demo.model.SimpleModel;
import hu.flowacademy.demo.service.CommonInterface;
import hu.flowacademy.demo.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequiredArgsConstructor
public class HelloController {

//    @Autowired
//    private final SimpleService simpleService;
//    @Autowired
//    @Qualifier("complexService")
//    private CommonInterface commonInterface;

//    public HelloController(SimpleService simpleService) {
//        System.out.println("hello, controller has been created!");
//        this.simpleService = simpleService;
//    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/getSimple")
    public String getSimple(@Qualifier("complexService") CommonInterface commonInterface) {
        return commonInterface.getSimpleMessage();
    }

    @GetMapping("/simple")
    public SimpleModel getAllSimples() {
        return new SimpleModel(UUID.randomUUID().toString());
    }
    @PostMapping("/simple")
    public SimpleModel createSimpleModel(@RequestBody SimpleModel simpleModel) {
        return simpleModel;
    }
    @PutMapping("/simple/{id}")
    public SimpleModel createSimpleModel(@PathVariable String id, @RequestBody SimpleModel simpleModel) {
        System.out.println(id);
        return simpleModel;
    }

    @DeleteMapping("/simple/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id, @RequestParam("name") String name) {
        System.out.println(id);
    }

}
