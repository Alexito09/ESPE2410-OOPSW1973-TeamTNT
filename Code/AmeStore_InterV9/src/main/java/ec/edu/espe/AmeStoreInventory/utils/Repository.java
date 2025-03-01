package ec.edu.espe.AmeStoreInventory.utils;

import java.util.List;
import org.bson.Document;

/**
 *
 * @author Andres Sandoval
 */
public interface Repository<T> {
    void save(T entity);
    void update(String id, T updatedData);
    boolean delete(String id);
    List<Document> findAll();
    Document findById(String id);
}
