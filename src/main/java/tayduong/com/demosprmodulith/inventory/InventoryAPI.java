package tayduong.com.demosprmodulith.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import tayduong.com.demosprmodulith.OrderCreatedEvent;

@Service
@Slf4j
public class InventoryAPI {

    @ApplicationModuleListener
    void onOrderCreated(OrderCreatedEvent createdEvent) {
        log.info("A new order has been created: {} - {}. Please check inventory!!!", createdEvent.productName(), createdEvent.id());
    }
}
