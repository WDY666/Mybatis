package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WDY
 * @Date 2020-10-20 15:57
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryParent {
    private Integer id;
    private Integer pid;
    private String cityName;
    private CategoryParent parent;
}
