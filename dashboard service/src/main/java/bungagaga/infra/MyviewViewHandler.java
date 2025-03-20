package bungagaga.infra;

import bungagaga.domain.*;
import bungagaga.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyviewViewHandler {

//<<< DDD / CQRS
    @Autowired
    private MyviewRepository myviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Myview myview = new Myview();
            // view 객체에 이벤트의 Value 를 set 함
            myview.setId(orderPlaced.getId());
            myview.setProductId(orderPlaced.getProductId());
            myview.setCustomerId(orderPlaced.getCustomerId());
            myview.setQty(orderPlaced.getQty());
            myview.setAddress(orderPlaced.getAddress());
            myview.setOrderStatus(ordered);
            // view 레파지 토리에 save
            myviewRepository.save(myview);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverystarted_then_UPDATE_1(@Payload Deliverystarted deliverystarted) {
        try {
            if (!deliverystarted.validate()) return;
                // view 객체 조회
            Optional<Myview> myviewOptional = myviewRepository.findById(Long.valueOf(deliverystarted.getOrderId()));

            if( myviewOptional.isPresent()) {
                 Myview myview = myviewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myview.setDeliveryStatus(delivery started);    
                // view 레파지 토리에 save
                 myviewRepository.save(myview);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

