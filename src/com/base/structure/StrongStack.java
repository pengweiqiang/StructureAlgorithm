/**
 * Copyright (C), 2012-2018, www.shopin.net
 * FileName: StrongStack
 * Author:   pengweiqiang
 * Date:     2018/11/14 15:31
 * Description: 增强版栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.base.structure;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈增强版栈〉
 *  解决Stack类中的问题：
 *  1、自动扩容问题
 *  2、存储为单一类型问题
 *
 * @author pengweiqiang
 * @create 2018/11/14
 * @since 1.0.0
 */
public class StrongStack {

    //栈内存储数组
    private Object[]datas;
    //栈顶元素指针
    private int top = -1;
    //栈的总容量
    private int size;

    /**
     * 默认构建容器为10的栈
     */
    public StrongStack(){
        size = 10;
        datas = new Object[size];
        top = -1;
    }

    public StrongStack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("初始容器长度不能小于0 "+initialCapacity);
        }
        top = -1;
        size = initialCapacity;
        datas = new Object[initialCapacity];
    }

    /**
     * 压栈
     * @param value
     * @return
     */
    public boolean push(Object value){
        isGrow(top+1);
        datas[++top] = value;
        return true;
    }

    /**
     * 是否需要扩容，return true 表示扩容现有长度的两倍， return false表示不需要扩容
     * @return
     */
    public boolean isGrow(int oldCapacity){
        //如果当前压入栈内的元素索引大于现有栈内元素长度，则需要扩容
        if(oldCapacity >= size){//需要扩容
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大两倍(左移一位)看是否超过int类型所表示的最大范围
            if((oldCapacity<<1) - Integer.MAX_VALUE >0){
                newCapacity = Integer.MAX_VALUE;
            }else{
                newCapacity = (oldCapacity<<1);//左移一位，相当于*2
            }
            this.size = newCapacity;
            datas = Arrays.copyOf(datas, size);

            return true;
        }else{
            return false;
        }
    }

    /**
     * 弹栈
     * @return
     */
    public Object pop(){
        Object item = peek();
        remove(top);
        return item;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public Object peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return datas[top];
    }

    /**
     * 删除栈顶元素
     * @param top
     * @return
     */
    private void remove(int top){
        if(top == -1){
            throw  new EmptyStackException();
        }
        datas[top] = null;
        this.top--;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    public static void main(String []args){
        StrongStack stack = new StrongStack(3);
        for(int i =0;i<10;i++){
            stack.push(i);
        }

        stack.push("abc");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());


        //反转字符串
        StrongStack  stack2 = new StrongStack();
        String str = "how are you";
        char[] cha = str.toCharArray();
        for(char c : cha){
            stack2.push(c);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop());
        }
    }

}