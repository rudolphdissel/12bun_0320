package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PlusQuantity extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String name;

    public PlusQuantity(Inventory aggregate) {
        super(aggregate);
    }

    public PlusQuantity() {
        super();
    }
}
//>>> DDD / Domain Event
