package Spring;

import Goods.Cart;
import Goods.ProductRepository;

public interface MessageRender {

    void render();
    Cart getCart();

    void setCart(Cart cart);

    ProductRepository getProductRepository();

    void setProductRepository(ProductRepository productRepository);

}
