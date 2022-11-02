package com.bwgjoseph.springbootmongodbdefaultmapping;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("person")
@Document("person")
public class Person {
    @Id
    private String id;
    @Builder.Default
    private String name = "";
    private int age;
    @Builder.Default
    private Integer height = 0;
    private boolean isAdult;
    private Address address;
    @Builder.Default
    private List<String> hobbies = List.of();
    @Builder.Default
    private List<Address> addresses = List.of();
}
