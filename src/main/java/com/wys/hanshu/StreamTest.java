package com.wys.hanshu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class StreamTest {
    public static void main(String[] args){
        User user1=new User(1,"a",21);
        User user2=new User(2,"b",23);
        User user3=new User(3,"c",25);
        User user4=new User(4,"d",23);
        User user5=new User(5,"e",22);
        List<User> list= Arrays.asList(user1,user2,user3,user4,user5);
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((u1,u2)->{return u1.compareTo(u2);})
                .limit(1)
                .forEach(System.out::println);
    }

    Long s=LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
}
