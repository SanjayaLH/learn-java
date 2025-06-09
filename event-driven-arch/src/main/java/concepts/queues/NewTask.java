package concepts.queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.util.ArrayList;
import java.util.List;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            boolean durable = true;
            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

            List<String> messages = new ArrayList<>();
            messages.add("First message");
            messages.add("Second message");
            messages.add("Third message");
            messages.add("Fourth message");
            messages.add("Fifth message");
            messages.add("Sixth message");
            messages.add("Seventh message");
            messages.add("Eighth message");
            messages.add("Ninth message");

            for (String m : messages) {
                channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, m.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + m + "'");
            }
        }
    }

}