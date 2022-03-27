package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Goods.Product;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private List<Product> products = List.of(
            Product.builder().id(1).title("apple").cost(30.5F).isVegan(true).build(),
            Product.builder().id(2).title("banana").cost(20.9F).isVegan(true).build(),
            Product.builder().id(3).title("carrot").cost(10.1F).isVegan(true).build(),
            Product.builder().id(4).title("chicken").cost(100.4F).isVegan(false).build(),
            Product.builder().id(5).title("fish").cost(250.0F).isVegan(false).build(),
            Product.builder().id(6).title("salad").cost(40.5F).isVegan(true).build(),
            Product.builder().id(7).title("bread").cost(24.3F).isVegan(true).build(),
            Product.builder().id(8).title("eag").cost(68.8F).isVegan(false).build(),
            Product.builder().id(9).title("strawberry").cost(240.2F).isVegan(true).build(),
            Product.builder().id(10).title("meat").cost(220.2F).isVegan(false).build(),
            Product.builder().id(11).title("potato").cost(18.7F).isVegan(true).build(),
            Product.builder().id(12).title("cabbage").cost(20.0F).isVegan(true).build(),
            Product.builder().id(13).title("tomato").cost(90.3F).isVegan(true).build(),
            Product.builder().id(14).title("cucumber").cost(45.0F).isVegan(true).build()
    );


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productCase", createProductCase(req.getParameter("isVegan")));
        getServletContext().getRequestDispatcher("/productCase.jsp").forward(req, resp);
    }

    //сформируем случайный набор продуктовой корзины
    private List<Product> createProductCase(String param) {
        Random rand = new Random();
        ArrayList<Product> productCase = new ArrayList<>();

        Product product = products.get(rand.nextInt(14));

        for (int i = 0; i < 10; ) {
            //Если продукт не веганский, а нужен веганский набор, то не кладем его
            if (!(param == "1" && !product.getIsVegan())) {
                productCase.add(product);
                i++;
            }
        }
        return productCase;
    }
}
