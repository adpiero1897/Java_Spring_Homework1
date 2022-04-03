package Goods;

public interface ProductRepository {

    public Product getProductForId(int id);
    public void addProduct(Product product);
    public void removeProductForId(int id);
    public int getMaxId();

    public void removeAllProducts();

    //ещё +1 метод randomFillFromListProducts заполнения корзины n-ным количеством товаров из общего репозитория
    public void randomFillFromListProducts(ProductRepository productRepositoryList, int n, boolean isVegan);

}
