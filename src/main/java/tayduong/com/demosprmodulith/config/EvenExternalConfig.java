package tayduong.com.demosprmodulith.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.modulith.events.EventExternalizationConfiguration;
import org.springframework.modulith.events.RoutingTarget;
import tayduong.com.demosprmodulith.OrderCompletedEvent;
import tayduong.com.demosprmodulith.OrderCreatedEvent;

import java.util.UUID;

@Configuration
public class EvenExternalConfig {

    @Bean
    EventExternalizationConfiguration eventExternalizationConfiguration() {
        return EventExternalizationConfiguration.externalizing()
                .select(EventExternalizationConfiguration.annotatedAsExternalized())
                .route(
                        OrderCreatedEvent.class,
                        it -> RoutingTarget.forTarget("tayduong.order.create").andKey(UUID.randomUUID().toString())

                )
                .mapping(
                        OrderCreatedEvent.class,
                        it -> new OrderCreatedEvent(it.productName(), it.id())
                )
                .route(
                        OrderCompletedEvent.class,
                        it -> RoutingTarget.forTarget("tayduong.order.complete").andKey(UUID.randomUUID().toString())
                )
                .mapping(
                        OrderCompletedEvent.class,
                        it -> new OrderCompletedEvent(it.productName(), it.id())
                )
                .build();
    }
}
