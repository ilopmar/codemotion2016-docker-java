package codemotion2016;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
public class ProducerApplication {

    private final static String queueName = "reverse";

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @RestController
    class ProducerController {

        @Autowired
        RabbitTemplate rabbitTemplate;

        @RequestMapping(method = RequestMethod.GET, path = "/producer")
        public String sendMsg(Optional<String> msg) {
            String messageSent = msg.orElse("Hola Codemotion");
            rabbitTemplate.convertAndSend(ProducerApplication.queueName, messageSent);

            return "Mensaje enviado = " + messageSent;
        }
    }
}
