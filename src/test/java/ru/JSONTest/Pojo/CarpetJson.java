package ru.JSONTest.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarpetJson {
    private String brandName;
    private String collectionName;
    private String composition;
    private Integer density;

}
