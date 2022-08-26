import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("--Menu--");
            System.out.println("1. Add new product ");
            System.out.println("2.Display");
            System.out.println("3.Search by Id");
            System.out.println("0.Exit");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch(choice){
                case 1:

                    System.out.println("Enter Id");
                    Scanner scanner1=new Scanner(System.in);
                    String id =scanner1.nextLine();
                    System.out.println("Enter name");
                    String name =scanner1.nextLine();
                    System.out.println("Enter manufacturer");
                    String manufacturer=scanner1.nextLine();
                    System.out.println("Enter price");
                    int price= scanner1.nextInt();
                    Product product=new Product(id,name,manufacturer,price);
                    Manager.addProduct(product);
                    writeToFile("product.txt", Manager.listProduct);
                    break;
                case 2:
                    List<Product> productDataFromFile = readDataFromFile("product.txt");
                    for (Product product1 :productDataFromFile ){
                        System.out.println(product1);
                    }
                    break;
                case 3:
                    System.out.println("Enter Id");
                    Scanner scanner2=new Scanner(System.in);
                    id=scanner2.nextLine();
                    System.out.println(Manager.searchProduct(id));
                    break;
                case 0:
                    System.exit(0);



            }
        }while( choice != 0);

    }

}
