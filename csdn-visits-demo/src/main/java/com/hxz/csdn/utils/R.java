package com.hxz.csdn.utils;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-05-03-19:36
 * @address 成都
 */
public class R<T> {
    private Integer code;
    private String message;
    private CsdnData data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CsdnData getData() {
        return data;
    }

    public void setData(CsdnData data) {
        this.data = data;
    }

    public static class CsdnData<T> {
        private Integer total;
        private List<T> list;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }
    }
}
