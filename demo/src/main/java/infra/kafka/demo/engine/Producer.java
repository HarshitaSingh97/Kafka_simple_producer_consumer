package infra.kafka.demo.engine;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;

import java.util.Date;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message){
        JSONObject obj = new JSONObject();
        obj.put("name", "hsingh");
        obj.put("message", message);
        String jsonText = JSONValue.toJSONString(obj);
        logger.info(String.format("Producing message -> %s", jsonText));

        this.kafkaTemplate.send("topic1", obj);

    }
}