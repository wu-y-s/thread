package com.wys.hanshu;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//四大函数式接口
public class functionTest {
    public static void main(String[] args){

        //函数型接口
        Function function=new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };

        //简化
        Function<String,String> function1=str->{return str;};


        //简单例子，断定型接口
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return o.isEmpty();
            }
        };

        //消费型接口
        Consumer<String> consumer=str->{System.out.println(str);};

        //供给型接口
        Supplier<Integer> supplier=()->{return 1024;};
    }
}
