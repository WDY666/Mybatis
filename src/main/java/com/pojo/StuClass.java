package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author WDY
 * @Date 2020-10-06 15:40
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuClass {
    private String cname;
    private Integer cid;
    private List<Student> student;
}
