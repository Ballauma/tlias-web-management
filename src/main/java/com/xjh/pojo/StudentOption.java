package com.xjh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ballauma
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOption {
    private List clazzList;
    private List dataList;
}
