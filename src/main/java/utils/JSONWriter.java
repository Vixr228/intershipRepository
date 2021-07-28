package utils;

import entities.documents.Document;
import entities.orgstuff.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Класс JSONWriter - нужен для записи созданных документов в json файл.
 * Документы группируются по полю Автора и отсортированы по регистрационному номеру (авторы отсортированы по алфавиту).
 */
public class JSONWriter {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void writeDocumentsToJson(List<Document> documents) throws IOException {
        Map<Person, List<Document>> map = documents.stream().sorted(Comparator.comparing(o -> o.getAuthor().getSurname()))
                .collect(Collectors.groupingBy(Document::getAuthor));
        TreeMap<Person, List<Document>> sorted = new TreeMap<>(map);

        for(Map.Entry<Person, List<Document>> item : sorted.entrySet()){
            FileWriter file = new FileWriter("src/main/resources/json/" + item.getKey().getFullName() + ".json");
            String str = gson.toJson(item.getValue());
            byte[] bytes = str.getBytes();
            file.write(new String(bytes, StandardCharsets.UTF_8));
            file.close();
        }
    }
}
