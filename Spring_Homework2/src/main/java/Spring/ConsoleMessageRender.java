package Spring;

import Goods.Cart;
import Goods.Product;
import Goods.ProductRepository;

public class ConsoleMessageRender implements MessageRender{


    Cart cart;
    ProductRepository productRepository;

    @Override
    public void render() {


        StringBuilder sb = new StringBuilder();
        sb.append("Выберите нужную вам операцию из списка:" + "\n"
                + "to empty - Опустошить товарную корзину" + "\n"
                + "to full - Заполнить товарную корзину всеми доступными товарами" + "\n"
                + "new Cart - Взять новую товарную корзину" + "\n"
                + "exit - Выйти" + "\n" + "\n"
                + "Вы также можете добавить в корзину любой номер из списка ниже (просто напишете этот номер):");
        for (int i = 0; i <= productRepository.getMaxId(); i++) {
            Product product = productRepository.getProductForId(i);
            if (product != null) {
                sb.append(product.getId() + ". " + product.getTitle() + " - " + product.getCost() + "руб.");
                product = null;
            }
        }
        sb.append("\n" + "А можно и удалить товар из корзины (номер со знаком -):");

        for (int i = 0; i <= cart.getMaxId(); i++) {
            Product product = cart.getProductForId(i);
            if (product != null) {
                sb.append(-product.getId() + ". " + product.getTitle() + " - " + product.getCost() + "руб.");
                product = null;
            }
        }
        System.out.println(sb.toString());
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


}
