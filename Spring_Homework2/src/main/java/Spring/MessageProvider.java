package Spring;

import Goods.Cart;
import Goods.ProductRepository;
import lombok.Getter;
import lombok.Setter;


public interface MessageProvider {

    String getMessageProvider();

    Cart getCart();

    void setCart(Cart cart);

    ProductRepository getProductRepository();

    void setProductRepository(ProductRepository productRepository);
}
