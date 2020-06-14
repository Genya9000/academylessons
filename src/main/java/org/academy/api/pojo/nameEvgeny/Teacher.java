package org.academy.api.pojo.nameEvgeny;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Teacher {
    private String teacherName;
    private List<Student> students;
}
