package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.AmeStoreInventory.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Andres Sandoval
 */
public class CustomerRepository implements Repository<Customer> {
    private final MongoCollection<Document> collection;

    public CustomerRepository(MongoDBConnectionManager connectionManager) {
        this.collection = connectionManager.getDatabase().getCollection("customer");
    }

    @Override
    public void save(Customer customer) {
        Document document = new Document("id", customer.getId())
                .append("name", customer.getName())
                .append("address", customer.getAddress())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone());
        collection.insertOne(document);
    }

    @Override
    public void update(String id, Customer updatedData) {
        Document query = new Document("id", id);
        Document update = new Document("$set", new Document()
                .append("name", updatedData.getName())
                .append("address", updatedData.getAddress())
                .append("email", updatedData.getEmail())
                .append("phone", updatedData.getPhone()));
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
        List<Document> customers = new ArrayList<>();
        try (var cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                customers.add(cursor.next());
            }
        }
        return customers;
    }

    @Override
    public Document findById(String id) {
        return collection.find(eq("id", id)).first();
    }
}
