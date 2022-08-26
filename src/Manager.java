import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<Product> listProduct=Main.readDataFromFile("product.txt");
    public static void addProduct(Product product){
        listProduct.add(product);

    }
    public static String searchProduct(String id){
        String result="";
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId().equals(id)){
              result+=  listProduct.get(i)+"\n";
            }
        }  return result;
    }
}
