package DataBase;

import Entities.Document;

public interface Storable {

    Document getDocumentById(int id);

    void saveDocument(Document document);

}
