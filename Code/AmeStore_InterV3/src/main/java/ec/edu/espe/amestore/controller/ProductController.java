package ec.edu.espe.amestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.amestore.model.Product;
import org.bson.Document;
import utils.MongoDBConection;

/**
 *
 * @author User
 */
public class ProductController {
        //save product
    public boolean Save(Product object){
      boolean answer = false;
      MongoDatabase db = MongoDBConection.conectar();
        MongoCollection<Document> collection = db.getCollection("Product");
        try{
            Document doc = new Document("Product to AmeStore", object.getDescription()).append("Status", object.getStatus());
            collection.insertOne(doc);
            
            answer= true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error to save product");
        }
      return answer;
    }
    
    public boolean ExistingCategory(String product){
      boolean exist = false;
      MongoDatabase db = MongoDBConection.conectar();
      MongoCollection<Document> collection = db.getCollection("Product");
      try{
          Document query = new Document("Product to AmeStore ", product);
          long count = collection.countDocuments(query);
          exist=(count > 0);
        }catch(Exception e){
            System.out.println("Error to consult to product");
        }
      return exist;
    }
    
    
}
