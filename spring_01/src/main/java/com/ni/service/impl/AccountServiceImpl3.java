package com.ni.service.impl;

import com.ni.dao.AccountDao;
import com.ni.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {

    //如果是经常变化的数据，并不适用于注入的方法
    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProp;

    public void setMyStr(String[] myStrs) {
        this.myStr = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProp(Properties myProps) {
        this.myProp = myProps;
    }

    public void saveAccount() {
        System.out.println("print myStr:");
        System.out.println(Arrays.toString(myStr));
        System.out.println("print myList");
        System.out.println(myList);
        System.out.println("print mySet");
        System.out.println(mySet);
        System.out.println("print myMap");
        System.out.println(myMap);
        System.out.println("print myProp");
        System.out.println(myProp);
    }

}
