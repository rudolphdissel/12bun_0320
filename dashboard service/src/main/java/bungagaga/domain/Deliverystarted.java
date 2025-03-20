package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

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
}
