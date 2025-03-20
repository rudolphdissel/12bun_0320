package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Messagesended extends AbstractEvent {

    private Long id;

    public Messagesended() {
        super();
    }
}
//>>> DDD / Domain Event
