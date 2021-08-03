package enums;

public enum DocumentType {
    INCOMING ("Входящий"),
    OUTGOING ("Исходящий"),
    TASK ("Поручение");

    private final String documentType;

    private DocumentType (String documentType) {
        this.documentType = documentType;
    }

    public static DocumentType getDocumentTypeByClassName(String className) {
        return DocumentType.valueOf(className.toUpperCase());
    }
}
