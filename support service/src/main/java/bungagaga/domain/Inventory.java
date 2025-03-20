package bungagaga.domain;

import bungagaga.SupportServiceApplication;
import bungagaga.domain.MinuseQuantity;
import bungagaga.domain.PlusQuantity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer qty;

    private String name;

    @PostPersist
    public void onPostPersist() {
        MinuseQuantity minuseQuantity = new MinuseQuantity(this);
        minuseQuantity.publishAfterCommit();

        PlusQuantity plusQuantity = new PlusQuantity(this);
        plusQuantity.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = SupportServiceApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void minusQuntity(Deliverystarted deliverystarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        

        repository().findById(deliverystarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void rollbackgoods(Deliverycancled deliverycancled) {
        //implement business logic here:

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        PlusQuantity plusQuantity = new PlusQuantity(inventory);
        plusQuantity.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deliverycancled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            PlusQuantity plusQuantity = new PlusQuantity(inventory);
            plusQuantity.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
