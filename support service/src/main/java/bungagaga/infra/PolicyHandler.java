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
    DeliveryRepository deliveryRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_DeliveryStart(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverystarted'"
    )
    public void wheneverDeliverystarted_MinusQuntity(
        @Payload Deliverystarted deliverystarted
    ) {
        Deliverystarted event = deliverystarted;
        System.out.println(
            "\n\n##### listener MinusQuntity : " + deliverystarted + "\n\n"
        );

        // Sample Logic //
        Inventory.minusQuntity(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancled'"
    )
    public void wheneverOrderCancled_DeliveryCancle(
        @Payload OrderCancled orderCancled
    ) {
        OrderCancled event = orderCancled;
        System.out.println(
            "\n\n##### listener DeliveryCancle : " + orderCancled + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryCancle(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverycancled'"
    )
    public void wheneverDeliverycancled_Rollbackgoods(
        @Payload Deliverycancled deliverycancled
    ) {
        Deliverycancled event = deliverycancled;
        System.out.println(
            "\n\n##### listener Rollbackgoods : " + deliverycancled + "\n\n"
        );

        // Sample Logic //
        Inventory.rollbackgoods(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
