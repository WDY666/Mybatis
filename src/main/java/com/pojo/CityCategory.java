package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @Author WDY
 * @Date 2020-10-19 22:26
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityCategory {
    private Integer id;
    private Integer pid;
    private String cityName;
    private List<CityCategory> children;

}
