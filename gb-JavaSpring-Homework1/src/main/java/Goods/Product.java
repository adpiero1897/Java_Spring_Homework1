package Goods;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private float cost;
    private Boolean isVegan;
}
