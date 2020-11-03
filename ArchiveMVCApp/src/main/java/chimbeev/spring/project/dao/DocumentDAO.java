package chimbeev.spring.project.dao;

import chimbeev.spring.project.models.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentDAO {
    private List<Document> documents;
    private static int DOCUMENTS_ID;
    {
        documents = new ArrayList<>();
        documents.add(new Document(++DOCUMENTS_ID, "Delivery Order", "Subway"));
        documents.add(new Document(++DOCUMENTS_ID, "Заказ 141", "Мак"));
        documents.add(new Document(++DOCUMENTS_ID, "Заказ 2342", "КФС"));
    }

    public List<Document> index() {
        return documents;
    }
    public Document show (int id) {
        return documents.stream().filter(document ->  document.getId() == id).findAny().orElse(null);
    }
    public void save(Document document) {
        document.setId(++DOCUMENTS_ID);
        documents.add(document);
    }
    public void update(int id, Document updatedDocument) {
        Document documentToBeUpdated = show(id);
        documentToBeUpdated.setName(updatedDocument.getName());
        documentToBeUpdated.setSender(updatedDocument.getSender());
    }
    public void delete(int id) {
        documents.removeIf(p -> p.getId() == id);
    }
}
