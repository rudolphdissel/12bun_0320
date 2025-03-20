package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Deliverystarted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer qty;
    private String status;
    private String orderId;
    private String address;

    public Deliverystarted(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverystarted() {
        super();
    }
}
//>>> DDD / Domain Event
