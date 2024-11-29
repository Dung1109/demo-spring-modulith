package tayduong.com.demosprmodulith.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tayduong.com.demosprmodulith.order.OrderAPI;

@RestController
public class AppController {

    private final OrderAPI orderAPI;

    public AppController(OrderAPI orderAPI) {
        this.orderAPI = orderAPI;
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        orderAPI.createOrder(name);
        return "Hello " + name;
    }
}
