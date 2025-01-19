package ec.edu.espe.amestore.model;

/**
 *
 * @author Andres Sandoval
 */
public class Category {

    private int idCategory;
    private String description;
    private int status;

    public Category() {
        this.idCategory = 0;
        this.description = "";
        this.status = 0;
    }

    public Category(int idCategory, String description, int status) {
        this.idCategory = idCategory;
        this.description = description;
        this.status = status;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
