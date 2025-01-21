package ec.edu.espe.amestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.amestore.model.Category;
import org.bson.Document;
import utils.MongoDBConection;

/**
 *
 * @author Andres Sandoval
 */
public class CategoryController {
    
    //save category
    public boolean Save(Category object){
      boolean answer = false;
      MongoDatabase db = MongoDBConection.conectar();
        MongoCollection<Document> collection = db.getCollection("Category");
        try{
            Document doc = new Document("Category to AmeStore", object.getDescription()).append("Status", object.getStatus());
            collection.insertOne(doc);
            
            answer= true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error to save category");
        }
      return answer;
    }
    
    public boolean ExistingCategory(String category){
      boolean exist = false;
      MongoDatabase db = MongoDBConection.conectar();
      MongoCollection<Document> collection = db.getCollection("Category");
      try{
          Document query = new Document("Category to AmeStore ", category);
          long count = collection.countDocuments(query);
          exist=(count > 0);
        }catch(Exception e){
            System.out.println("Error to consult to category");
        }
      return exist;
    }
    
    
    
    
    
    
    //Video 7 por corregir. 
       public boolean update(Category object, int idCategory){
      boolean answer = false;
      MongoDatabase db = MongoDBConection.conectar();
        MongoCollection<Document> collection = db.getCollection("Category");
        try{
            Document doc = new Document("Category to AmeStore", object.getDescription()).append("Status", object.getStatus());
            collection.insertOne(doc);
            
            answer= true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro al actualizar categoria");
        }
      return answer;
    }

}

