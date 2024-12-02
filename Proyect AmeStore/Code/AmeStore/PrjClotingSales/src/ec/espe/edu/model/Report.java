
package ec.espe.edu.model;

import java.util.Date;

/**
 *
 * @author Lisbeth Tipan 
 */
import java.util.Date;
import java.util.List;

public class Report {
    private String type;
    private Date startDate;
    private Date endDate;
    private List<Transaction> data;

  
    public Report(String type, Date startDate, Date endDate, List<Transaction> data) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.data = data;
    }

  
    public void exportPDF() {
        System.out.println("Exportando reporte a PDF...");
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
        this.data = data;
    }
}

