package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MinuseQuantity extends AbstractEvent {

    private Long id;
    private Integer qty;

    public MinuseQuantity(Inventory aggregate) {
        super(aggregate);
    }

    public MinuseQuantity() {
        super();
    }
}
//>>> DDD / Domain Event
