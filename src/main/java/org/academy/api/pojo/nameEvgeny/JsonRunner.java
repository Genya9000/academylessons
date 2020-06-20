package org.academy.api.pojo.nameEvgeny;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import java.util.List;

public class JsonRunner {
    @SneakyThrows
    public static void main(String[] args) {

    List<Student> students = Arrays.asList(Student.builder().name("Piter").age(20)
            .subjects(new String[]{"history", "biology"}).build(), Student.builder().name("Ivan").age(21)
            .subjects(new String[]{"physics", "literature"}).build());
    Teacher teacher = Teacher.builder().teacherName("Garibaldy").students(students).build();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String serializedTeacher = gson.toJson(teacher);

    System.out.println(FileUtils
                .readFileToString(new File("src/main/resources/jsonEvgeny/issueComment.json"), StandardCharsets
                        .UTF_8));

    File myfile = new File("src/main/resources/jsonEvgeny/commentResponse.json");
        FileUtils.writeStringToFile(myfile, serializedTeacher,
                StandardCharsets.UTF_8.name());

        Teacher teacher1 = gson.fromJson(serializedTeacher, Teacher.class);
        System.out.println(teacher1.toString());



    }
}
