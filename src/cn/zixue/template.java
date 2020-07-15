package cn.zixue;

import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2020-07-14 20:53
 */

/*模板
二者的区别：Live Templates 可以自定义，而 Postfix Completion 不可以。同时，
        有些操作二者都提供了模板，Postfix Templates 较 Live Templates 能快 0.01 秒*/

public class template {


    public static void main(String[] args) {

        //fori
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
        //iter
        String[]arr={"fggf","gfgff"};
        for (String s : arr) System.out.println(s);

        ArrayList<Object> alist = new ArrayList<>();
        alist.add(1);
        for (Object oo : alist) {
            System.out.println(oo);
        }
    }
    public void test(){

    }
}
