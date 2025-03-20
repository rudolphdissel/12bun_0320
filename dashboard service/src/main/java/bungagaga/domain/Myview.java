package bungagaga.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Myview_table")
@Data
public class Myview {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String customerId;
    private String productId;
    private Integer qty;
    private String address;
    private String orderStatus;
    private String deliveryStatus;
    private Integer price;
}
