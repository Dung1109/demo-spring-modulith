package tayduong.com.demosprmodulith.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tayduong.com.demosprmodulith.OrderCompletedEvent;
import tayduong.com.demosprmodulith.OrderCreatedEvent;

@Service
public class OrderAPI {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderAPI(OrderRepository orderRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.orderRepository = orderRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public void createOrder(String orderName) {
        Order order = Order.builder().productName(orderName).build();
        Order save = orderRepository.save(order);
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(save.getProductName(), save.getId()));
        applicationEventPublisher.publishEvent(new OrderCompletedEvent(save.getProductName(), save.getId()));
    }
}
