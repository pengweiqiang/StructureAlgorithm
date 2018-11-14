/**
 * Copyright (C), 2012-2018, www.shopin.net
 * FileName: Stack
 * Author:   pengweiqiang
 * Date:     2018/11/14 12:30
 * Description: 栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.base.structure;

/**
 * 〈一句话功能简述〉<br> 
 * 〈栈〉
 * 栈：又称堆栈或堆叠，栈作为一种数据结构，是一种只能在一端进行插入和删除操作的特殊性线表。它按照先进后出(Last In First Out)的原则存储数据，先进入的数据被压入栈底。栈具有记忆作用，对栈的插入和删除操作，不需要改变栈底指针。
 *
 *  当前实现的栈局限性：
 *  1、自动扩容问题
 *  2、存储类型只能为单一类型
 *
 * @author pengweiqiang
 * @create 2018/11/14
 * @since 1.0.0
 */
public class Stack {

    private int datas[];//栈内元素
    private int maxSize;//栈内最大长度
    private int top;//栈顶元素索引

    public Stack(int size){
        this.maxSize = size;
        this.datas = new int[maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param value
     * @return
     */
    public boolean push(int value) throws Exception{
        if(top>maxSize-1){
            throw new Exception("索引越界"+top+"  size="+maxSize);
        }
        datas[++top]= value;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        return datas[top--];
    }

    /**
     * 访问栈顶元素
     * @return
     */
    public int peek() throws Exception{
        if(top < 0){
            throw new Exception("索引越界"+top+"  size="+maxSize);
        }
        return datas[top];
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top < 0;
    }

    /**
     * 栈内是否已满
     * @return
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    public static void main(String []args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(3);
        stack.push(5);
        stack.push(1);

        System.out.println("栈顶元素："+stack.peek());

        while (!stack.isEmpty()){
            System.out.println("弹出元素："+stack.pop());
        }

    }



}