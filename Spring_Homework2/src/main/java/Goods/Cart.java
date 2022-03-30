package Goods;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cart")
@Scope("prototype")
public class Cart extends ProductRepositoryList {

    //Корзина тоже представляет из себя определенный репозиторий продуктов с их КОЛЛЕКЦИЕЙ, зашитой внутри неё

}
