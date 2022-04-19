package com.hxz.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-19-22:17
 * @address 成都
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity implements Serializable {
    private String id;
    private String username;
    private Integer age;
}
