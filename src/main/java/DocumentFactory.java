public class DocumentFactory {

    private static int documentCounter;
    public Document createDocument(DocumentType documentType){
        Document document = null;

        switch (documentType){
            case TASK:
                document = new Task();
                break;
            case INCOMING:
                document = new Incoming();
                break;
            case OUTGOING:
                document = new Outgoing();
                break;
        }

        document.setRegistrationNumber(documentCounter++);
        return document;
    }
}
