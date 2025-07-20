package com.luanmiranda.fakeapi.FakeAPI.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "price")
    private BigDecimal price;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "category")
    private String category;

    @JsonProperty(value = "image")
    private String image;
}
