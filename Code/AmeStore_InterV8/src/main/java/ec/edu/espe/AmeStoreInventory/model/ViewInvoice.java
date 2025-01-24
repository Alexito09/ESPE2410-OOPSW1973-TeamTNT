package ec.edu.espe.AmeStoreInventory.model;

import java.util.List;
import org.bson.Document;

/**
 *
 * @author Andres Sandoval
 */
public class ViewInvoice {
    
    private Document invoice;

    public ViewInvoice(Document invoice) {
        this.invoice = invoice;
    }

    public String createMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura\n");
        sb.append("------------------------------\n");
        sb.append("Cliente: ").append(invoice.getString("customerName")).append("\n");
        sb.append("Dirección: ").append(invoice.getString("customerAddress")).append("\n");
        sb.append("Teléfono: ").append(invoice.getString("customerPhone")).append("\n");
        sb.append("------------------------------\n");
        sb.append("Items:\n");

        List<Document> items = (List<Document>) invoice.get("items");
        for (Document item : items) {
            sb.append(item.getInteger("quantity")).append(" x ")
              .append(item.getString("productName")).append(" @ ")
              .append(item.getDouble("price")).append(" c/u = ")
              .append(item.getDouble("subtotal")).append("\n");
        }

        sb.append("------------------------------\n");
        sb.append("Subtotal: ").append(invoice.getDouble("subtotal")).append("\n");
        sb.append("IVA: ").append(invoice.getDouble("iva")).append("\n");
        sb.append("Total: ").append(invoice.getDouble("total")).append("\n");
        sb.append("------------------------------\n");

        return sb.toString();
    }
}
