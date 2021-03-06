package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2020/10/19 0019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private Integer pid;
    private String cityName;
    private Set<City> children;
}
