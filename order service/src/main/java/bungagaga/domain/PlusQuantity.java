package bungagaga.domain;

import bungagaga.domain.*;
import bungagaga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PlusQuantity extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String name;
}
