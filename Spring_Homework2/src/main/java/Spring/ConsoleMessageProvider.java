package Spring;

import Goods.Cart;
import Goods.Product;
import Goods.ProductRepository;

import java.util.Scanner;

public class ConsoleMessageProvider implements MessageProvider {

    Cart cart;
    ProductRepository productRepository;

    private static final Scanner SC = new Scanner(System.in);

    @Override
    public String getMessageProvider() {

        String str;
        do {
            str = SC.nextLine();
        } while (!isValidOperation(str));
        return str;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Override
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private boolean isValidOperation(String str) {
        if (str.equalsIgnoreCase("to empty") || str.equalsIgnoreCase("to full")
                || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("new Cart")) {
            return true;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("!!!Запрашиваемая вами операция не была распознана!!!");
            return false;
        }
    }

}
