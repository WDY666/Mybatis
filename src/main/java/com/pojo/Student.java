package com.pojo;

import lombok.*;

import java.util.List;

/**
 * @Author WDY
 * @Date 2020-09-20 14:25
 * @Description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    private Integer cid;
    private List<StuClass> subject;

}
