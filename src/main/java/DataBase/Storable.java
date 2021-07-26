package DataBase;

import Entities.Documents.Document;

public interface Storable {

    Document getDocumentById(int id);

    void saveDocument(Document document);

}
