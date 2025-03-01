package ec.edu.espe.AmeStoreInventory.utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Andres Sandoval
 */

public class InvoiceRepository {
    private final MongoCollection<Document> collection;

    public InvoiceRepository(MongoDBConnectionManager connectionManager) {
        this.collection = connectionManager.getDatabase().getCollection("Invoices");
    }

    public boolean save(Document invoice) {
        try {
            collection.insertOne(invoice);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
