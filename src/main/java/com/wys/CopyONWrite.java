package com.wys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyONWrite {
    public static void main(String[] args) {
//        List<String> list= Collections.synchronizedList(new ArrayList<>());
//        List<String> list=new Vector<>();

        //写入时复制
        List<String> list=new CopyOnWriteArrayList<>();
    }
}
