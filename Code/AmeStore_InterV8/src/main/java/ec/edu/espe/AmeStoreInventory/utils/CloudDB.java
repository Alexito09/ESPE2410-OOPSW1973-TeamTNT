package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.AmeStoreInventory.model.Customer;
import ec.edu.espe.AmeStoreInventory.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author TEAM TNT
 */
public class CloudDB {
    
private MongoClient mongoClient;
    private MongoDatabase database;

    public CloudDB() {
        try {
            // Create MongoDB client
            String connectionString = "mongodb+srv://daullcu:daullcu@cluster0.dxj9m.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
            ConnectionString connString = new ConnectionString(connectionString);

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connString)
                    .serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
                    .build();

            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase("BaseAmeStore");

        } catch (MongoException e) {
            System.err.println("Error initializing MongoDB: " + e.getMessage());
        }
    }

    // Collection access method
    private MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    // Product operations
    public void uploadProductData(Product product) {
        MongoCollection<Document> collection = getCollection("product");

        Document document = new Document("id", product.getId())
                .append("name", product.getName())
                .append("description", product.getDescription())
                .append("quantity", product.getQuantity())
                .append("size", product.getSize())
                .append("price", product.getPrice())
                .append("category", product.getCategory());

        try {
            collection.insertOne(document);
            System.out.println("Product data saved successfully!");
        } catch (MongoException e) {
            System.err.println("Error inserting document: " + e.getMessage());
        }
    }

    public boolean productExists(String id) {
        MongoCollection<Document> collection = getCollection("product");

        Document query = new Document("id", id);
        return collection.find(query).first() != null;
    }

    public void updateProduct(Product product) {
        MongoCollection<Document> collection = getCollection("product");

        Document query = new Document("id", product.getId());
        Document updatedData = new Document("$set", new Document()
                .append("name", product.getName())
                .append("description", product.getDescription())
                .append("quantity", product.getQuantity())
                .append("size", product.getSize())
                .append("price", product.getPrice())
                .append("category", product.getCategory()));

        try {
            collection.updateOne(query, updatedData);
            System.out.println("Product data updated successfully!");
        } catch (MongoException e) {
            System.err.println("Error updating document: " + e.getMessage());
        }
    }

    public List<Document> getAllProducts() {
        MongoCollection<Document> collection = getCollection("product");

        List<Document> products = new ArrayList<>();
        try (var cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                products.add(cursor.next());
            }
        } catch (MongoException e) {
            System.err.println("Error fetching documents: " + e.getMessage());
        }
        return products;
    }

    public void deleteProduct(String id) {
        MongoCollection<Document> collection = getCollection("product");
        Document query = new Document("id", id);

        try {
            DeleteResult result = collection.deleteOne(query);
            if (result.getDeletedCount() > 0) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("No product found with the given ID.");
            }
        } catch (MongoException e) {
            System.err.println("Error deleting document: " + e.getMessage());
        }
    }

    // Customer operations
    public void uploadCustomerData(Customer customer) {
        MongoCollection<Document> collection = getCollection("customer");

        Document document = new Document("id", customer.getId())
                .append("name", customer.getName())
                .append("address", customer.getAddress())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone());


    try {
        collection.insertOne(document);
        System.out.println("Customer data saved successfully!");
    } catch (MongoException e) {
        System.err.println("Error inserting document: " + e.getMessage());
    }    }
   

    public List<Document> searchCustomerById(String id){
        MongoCollection<Document> collection = getCollection("customer");

        Document query = new Document("id", id);
        List<Document> results = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(query).iterator()) {
            while (cursor.hasNext()) {
                results.add(cursor.next());
            }
        }

        return results;
    }

    public List<Document> getAllCustomers() {
        MongoCollection<Document> collection = getCollection("customer");
        List<Document> results = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                results.add(cursor.next());
            }
        }

        return results;
    }

    public void updateCustomer(String id, Document updatedData) {
        MongoCollection<Document> collection = getCollection("customer");
        collection.updateOne(eq("id", id), new Document("$set", updatedData));
    }

    public boolean deleteCustomer(String id) {
        MongoCollection<Document> collection = getCollection("customer");
        Bson filter = eq("id", id);

        try {
            DeleteResult result = collection.deleteOne(filter);
            return result.getDeletedCount() > 0;
        } catch (MongoException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Document findCustomerByID(String id) {

 MongoCollection<Document> collection = database.getCollection("customer");
    Document query = new Document("id", id);
    return collection.find(query).first();
    }


    
    
    public boolean saveInvoice(Document invoice) {
    try {
        MongoCollection<Document> collection = database.getCollection("invoices");
        collection.insertOne(invoice);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}

