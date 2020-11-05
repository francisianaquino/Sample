package com.example.VirtualTour.entities;

import com.example.VirtualTour.enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="visitors")
@JsonPropertyOrder(value = {"id", "name", "province", "age", "sex", "institution"})
public class Visitor {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @Valid
    @NotBlank(message = "province is required")
    @JsonProperty(value = "province")
    private String province;

    @Valid
    @NotBlank(message = "age is required")
    @JsonProperty(value = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @JsonProperty(value = "sex")
    private Sex sex;

    @Valid
    @NotBlank(message = "institution is required")
    @JsonProperty(value = "institution")
    private String institution;
}
