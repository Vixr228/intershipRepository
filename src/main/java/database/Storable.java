package database;

import entities.documents.Document;

public interface Storable {

    Document getDocumentById(int id);

    void saveDocument(Document document);

}
