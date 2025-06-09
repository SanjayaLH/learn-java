package concepts.channels;

import com.rabbitmq.client.*;

public class RawChannelExample {
    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("localhost");
        try (Connection conn = cf.newConnection();
             /**
              * Channels are long-lived (open once, reuse many calls) to avoid the cost of repeated TCP handshakes.
              */
             Channel ch    = conn.createChannel()) {             // ← open channel

            // 1. Declare queue
            ch.queueDeclare("orders", true, false, false, null);

            // 2. Publish a persistent text message
            String payload = "Order 1001";
            ch.basicPublish(
                    /* exchange */   "",
                    /* routingKey */ "orders",
                    /* props */      MessageProperties.PERSISTENT_TEXT_PLAIN,
                    payload.getBytes()
            );
            System.out.println("Published: " + payload);
        } // ch.close() and conn.close() automatically
    }
}
