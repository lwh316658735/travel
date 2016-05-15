package com.travel.ac.bean;

import java.util.List;

/**
 * Created by lwh on 2016/5/14.
 * description
 */
public class OrderJson {


    /**
     * bean : null
     * id : null
     * list : [{"check_in":"0","date":"1462931408427","orderNo":"2016090710001","price":null},{"check_in":"0","date":"1462932205129","orderNo":"2016102410000","price":null}]
     * name : null
     * orderNo : null
     * phoneNo : null
     * price : null
     * ret : 0
     * table : order
     * type : 1
     * user : 123456
     */

    private Object         bean;
    private Object         id;
    private Object         name;
    private Object         orderNo;
    private Object         phoneNo;
    private Object         price;
    private int            ret;
    private String         table;
    private String         type;
    private String         user;
    /**
     * check_in : 0
     * date : 1462931408427
     * orderNo : 2016090710001
     * price : null
     */

    private List<ListBean> list;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Object orderNo) {
        this.orderNo = orderNo;
    }

    public Object getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Object phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String check_in;
        private String date;
        private String orderNo;
        private Object price;
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCheck_in() {
            return check_in;
        }

        public void setCheck_in(String check_in) {
            this.check_in = check_in;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }
    }
}
