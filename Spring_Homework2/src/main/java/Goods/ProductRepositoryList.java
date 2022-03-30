package Goods;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProductRepositoryList implements ProductRepository {

    protected Map<Integer, Product> productList = new HashMap<>();
    protected Integer IdInCart = 1;

    @Override
    public Product getProductForId(int id) {
        return productList.get(id);
    }

    @Override
    public void addProduct(Product product) {
        productList.put(IdInCart, product);
        IdInCart++;
    }

    @Override
    public void removeProductForId(int id) {
        productList.remove(IdInCart);
    }

    @Override
    public void removeAllProducts() {
        productList = new HashMap<>();
        IdInCart = 1;
    }

    @Override
    public int getMaxId(){
        return IdInCart;
    }

    @Override
    public void randomFillFromListProducts(ProductRepository productRepositoryList, int n, boolean isVegan) {
        Random rand = new Random();
        for (int i = 0; i < n; ) {
            Product product = productRepositoryList.getProductForId(rand.nextInt(14));
            //Если продукт не веганский, а нужен веганский набор, то не кладем его
            if (!isVegan || product.getIsVegan()) {
                addProduct(product);
                i++;
            }
        }
    }
}
