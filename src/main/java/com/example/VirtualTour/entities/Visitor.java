package com.example.VirtualTour.entities;

import com.example.VirtualTour.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="visitors")
@JsonPropertyOrder(value = {"id", "name", "province", "age", "sex", "institution", "date_added"})
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
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

    @CreationTimestamp
    @Column(updatable = false)
    @JsonProperty(value = "date_added")
    private Date date_added;
}
