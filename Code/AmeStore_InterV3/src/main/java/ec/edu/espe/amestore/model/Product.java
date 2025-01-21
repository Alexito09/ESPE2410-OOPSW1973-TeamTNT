package ec.edu.espe.amestore.model;

/**
 *
 * @author User
 */
public class Product {
    
    //Atributos
    private int idProduct;
    private String name;
    private int amount;
    private double price;
    private String description;
    private int percentageIva;
    private int idCategory;
// Constructor 
public Product(){
    this.idProduct = 0;
    this.name = "";
    this.amount =0;
    this.price = 0.0;
    this.description = "";
    this.percentageIva = 0;
    this.idCategory =0;
}

    public Product(int idProduct, String name, int amount, double price, String description, int percentageIva, int idCategory) {
        this.idProduct = idProduct;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.description = description;
        this.percentageIva = percentageIva;
        this.idCategory = idCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercentageIva() {
        return percentageIva;
    }

    public void setPercentageIva(int percentageIva) {
        this.percentageIva = percentageIva;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPorcentageIva(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
}
