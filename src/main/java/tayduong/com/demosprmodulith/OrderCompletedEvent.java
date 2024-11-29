package tayduong.com.demosprmodulith;

import org.springframework.modulith.events.Externalized;

@Externalized
public record OrderCompletedEvent(String productName, Long id) {
}
