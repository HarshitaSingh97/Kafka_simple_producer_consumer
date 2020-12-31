package infra.kafka.demo.engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import java.io.IOException;
@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = {"topic1"}, groupId = "group_id")
    public void consume(Object message) throws IOException {
        logger.info("consumed");
    }
}
