package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer price;
    private Integer qty;
    private String address;

    public OrderCancled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancled() {
        super();
    }
}
//>>> DDD / Domain Event
