package bungagaga.infra;

import bungagaga.config.kafka.KafkaProcessor;
import bungagaga.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverycancled'"
    )
    public void wheneverDeliverycancled_Updateorderstate(
        @Payload Deliverycancled deliverycancled
    ) {
        Deliverycancled event = deliverycancled;
        System.out.println(
            "\n\n##### listener Updateorderstate : " + deliverycancled + "\n\n"
        );

        // Sample Logic //
        Order.updateorderstate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PlusQuantity'"
    )
    public void wheneverPlusQuantity_Mailforwaiting(
        @Payload PlusQuantity plusQuantity
    ) {
        PlusQuantity event = plusQuantity;
        System.out.println(
            "\n\n##### listener Mailforwaiting : " + plusQuantity + "\n\n"
        );

        // Sample Logic //
        Order.mailforwaiting(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
