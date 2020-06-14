package org.academy.api.pojo.nameEvgeny;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private int age;
    private String[] subjects;

}
