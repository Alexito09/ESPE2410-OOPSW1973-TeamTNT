package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.AmeStoreInventory.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Andres Sandoval
 */
public class ProductRepository implements Repository<Product> {
    private final MongoCollection<Document> collection;

    public ProductRepository(MongoDBConnectionManager connectionManager) {
        this.collection = connectionManager.getDatabase().getCollection("product");
    }

    @Override
    public void save(Product product) {
        Document document = new Document("id", product.getId())
                .append("name", product.getName())
                .append("description", product.getDescription())
                .append("quantity", product.getQuantity())
                .append("size", product.getSize())
                .append("price", product.getPrice())
                .append("category", product.getCategory());
        collection.insertOne(document);
    }

    @Override
    public void update(String id, Product updatedData) {
        Document query = new Document("id", id);
        Document update = new Document("$set", new Document()
                .append("name", updatedData.getName())
                .append("description", updatedData.getDescription())
                .append("quantity", updatedData.getQuantity())
                .append("size", updatedData.getSize())
                .append("price", updatedData.getPrice())
                .append("category", updatedData.getCategory()));
        collection.updateOne(query, update);
    }

    @Override
    public boolean delete(String id) {
        Bson filter = eq("id", id);
        DeleteResult result = collection.deleteOne(filter);
        return result.getDeletedCount() > 0;
    }

    @Override
    public List<Document> findAll() {
        List<Document> products = new ArrayList<>();
        try (var cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                products.add(cursor.next());
            }
        }
        return products;
    }

    @Override
    public Document findById(String id) {
        return collection.find(eq("id", id)).first();
    }
}

