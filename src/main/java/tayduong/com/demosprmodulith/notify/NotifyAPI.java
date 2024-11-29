package tayduong.com.demosprmodulith.notify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import tayduong.com.demosprmodulith.OrderCreatedEvent;

@Service
@Slf4j
public class NotifyAPI {

    @ApplicationModuleListener
    void onOrderCreated(OrderCreatedEvent createdEvent) {
        log.info("Order created: {} - {}", createdEvent.productName(), createdEvent.id());
    }

}
