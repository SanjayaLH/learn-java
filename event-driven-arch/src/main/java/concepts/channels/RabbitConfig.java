package concepts.channels;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory factory =
                new CachingConnectionFactory("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // Cache up to 25 channels per connection
        factory.setChannelCacheSize(25);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            CachingConnectionFactory ccf) {
        return new RabbitTemplate(ccf);
    }
}
