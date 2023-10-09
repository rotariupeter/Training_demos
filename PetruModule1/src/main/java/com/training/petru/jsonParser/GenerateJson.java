package com.training.petru.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateJson {

    public static void main(String[] args) {

        generateJsonFile();
    }

    private static void generateJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());

        List<Student> students= new ArrayList<>();
        students.add(new Student("Petru","Rotariu", LocalDate.of(1980, 5, 15)));
        students.add(new Student("Petru1","Rotariu1", LocalDate.of(1980, 7, 14)));
        students.add(new Student("Petru2","Rotariu2", LocalDate.of(1980, 10, 22)));
        students.add(new Student("Petru3","Rotariu3", LocalDate.of(1980, 1, 2)));

        List<Collages.Collage> collages = new ArrayList<>();

        collages.add(new Collages.Collage("Auburn University",new Location("Alabama",new Address("Auburn, AL")),students));
        collages.add(new Collages.Collage("Samford University",new Location("Birmingham",new Address("Birmingham, AL")),students));
        collages.add(new Collages.Collage("Tuskegee University",new Location("Tuskegee",new Address("Tuskegee, AL")),students));
        collages.add(new Collages.Collage("Huntingdon College",new Location("Montgomery",new Address("Montgomery, AL")),students));

        Collages colleges = new Collages(collages);

        try {
            String json = objectMapper.writeValueAsString(colleges);

            try (InputStream inputStream = new ByteArrayInputStream(json.getBytes());
                 FileOutputStream fileOutputStream = new FileOutputStream("colleges5.json")) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
