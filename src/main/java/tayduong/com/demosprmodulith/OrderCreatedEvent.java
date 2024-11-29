package tayduong.com.demosprmodulith;

import org.springframework.modulith.events.Externalized;

//@Externalized("tayduong.order.create::#this")
@Externalized
public record OrderCreatedEvent(String productName, Long id) {
}
