package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Deliverycancled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer price;
    private Integer qty;
    private String customerAddress;

    public Deliverycancled(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverycancled() {
        super();
    }
}
//>>> DDD / Domain Event
