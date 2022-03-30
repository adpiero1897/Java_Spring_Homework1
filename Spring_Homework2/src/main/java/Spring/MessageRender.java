package Spring;

import Goods.Cart;
import Goods.ProductRepository;

public interface MessageRender {

    void render();

    //Перегрузка метоад для вывода единичных сообщений
    void render(String str);

    Cart getCart();

    void setCart(Cart cart);

    ProductRepository getProductRepository();

    void setProductRepository(ProductRepository productRepository);

}
