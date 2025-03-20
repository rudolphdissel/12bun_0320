package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliverycancled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
    private Integer price;
    private Integer qty;
    private String customerAddress;
}
