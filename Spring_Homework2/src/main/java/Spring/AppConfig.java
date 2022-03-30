package Spring;

import Goods.Cart;
import Goods.Product;
import Goods.ProductRepository;
import Goods.ProductRepositoryList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "productRepository")
    public ProductRepositoryList productRepository() {
        ProductRepositoryList productRepositoryList = new ProductRepositoryList();
        productRepositoryList.addProduct(Product.builder().id(1).title("apple").cost(30.5F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(2).title("banana").cost(20.9F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(3).title("carrot").cost(10.1F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(4).title("chicken").cost(100.4F).isVegan(false).build());
        productRepositoryList.addProduct(Product.builder().id(5).title("fish").cost(250.0F).isVegan(false).build());
        productRepositoryList.addProduct(Product.builder().id(6).title("salad").cost(40.5F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(7).title("bread").cost(24.3F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(8).title("eag").cost(68.8F).isVegan(false).build());
        productRepositoryList.addProduct(Product.builder().id(9).title("strawberry").cost(240.2F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(10).title("meat").cost(220.2F).isVegan(false).build());
        productRepositoryList.addProduct(Product.builder().id(11).title("potato").cost(18.7F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(12).title("cabbage").cost(20.0F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(13).title("tomato").cost(90.3F).isVegan(true).build());
        productRepositoryList.addProduct(Product.builder().id(14).title("cucumber").cost(45.0F).isVegan(true).build());
        return productRepositoryList;
    }

    @Bean(name = "cart")
    public Cart cart(ProductRepository productRepository) {
        Cart cart = new Cart();
        //Заполним изначально корзину 5 разными (НЕвеганскими) товарами
        cart.randomFillFromListProducts(productRepository,5,false);
        return cart;
    }

    @Bean(name = "consoleMessageRender")
    public MessageRender consoleMessageRender(Cart cart, ProductRepository productRepository) {
        MessageRender consoleMessageRender = new ConsoleMessageRender();
        consoleMessageRender.setCart(cart);
        consoleMessageRender.setProductRepository(productRepository);
        return consoleMessageRender;
    }

    @Bean(name = "consoleMessageProvider")
    public MessageProvider consoleMessageProvider() {
        MessageProvider consoleMessageProvider = new ConsoleMessageProvider();
        return consoleMessageProvider;
    }

}
