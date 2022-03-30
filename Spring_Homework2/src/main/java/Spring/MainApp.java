package Spring;

import Goods.Cart;
import Goods.Product;
import Goods.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        MessageRender messageRender = context.getBean("consoleMessageRender", MessageRender.class);
        MessageProvider messageProvider = context.getBean("consoleMessageProvider", MessageProvider.class);

        while (true) {
            messageRender.render();
            String str = messageProvider.getMessageProvider();
            if (str.equalsIgnoreCase("to empty")) {
                cart.removeAllProducts();
            } else if (str.equalsIgnoreCase("to full")) {
                cart.removeAllProducts();
                for (int i = 0; i <= productRepository.getMaxId(); i++) {
                    Product product = productRepository.getProductForId(i);
                    if (product != null) {
                        cart.addProduct(product);
                        product = null;
                    }
                }
            } else if (str.equalsIgnoreCase("new Cart")) {
                cart = context.getBean("cart", Cart.class);
                messageRender.setCart(cart);
                messageProvider.setCart(cart);
                messageRender.render("Взяли новую корзину");
            } else if (str.equalsIgnoreCase("exit")) {
                System.exit(100);
            } else {
                int i = Integer.parseInt(str);

                if (i >= 0) {
                    if(i<=productRepository.getMaxId()) {
                        Product product = productRepository.getProductForId(i);
                        cart.addProduct(product);
                        messageRender.render("Добавили в корзину продукт " + product.getTitle());
                    }
                    else {
                        messageRender.render("Товар для добавления с данным id НЕ найден");
                    }
                } else{
                    if(-i<=cart.getMaxId()) {
                        messageRender.render("Удаляем из корзины продукт " + cart.getProductForId(-i).getTitle());
                        cart.removeProductForId(-i);
                    }else{
                        messageRender.render("Товар для удаления с данным id НЕ найден");
                    }
                }

            }

        }
    }
}
