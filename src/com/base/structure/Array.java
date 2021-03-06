/**
 * Copyright (C), 2012-2018, www.shopin.net
 * FileName: Array
 * Author:   pengweiqiang
 * Date:     2018/11/13 14:54
 * Description: 数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.base.structure;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数组〉
 *  数据结构的基本功能：
 *  1、如何插入一条新的数据项
 *  2、如何寻找某一特定的数据项
 *  3、如何删除某一特定的数据项
 *  4、如何迭代的访问各个数据项，以便进行显示或其他操作
 *
 *
 *  数组的局限性：
 *  1、插入块：对于无序数组，案例的数组是无序的，即元素没有按照从大到小或者某个特定的顺序排列，只是按照插入的顺序排列。无序数组增加一个元素很简单，只需要在
 *  数组末尾添加元素即可，但是有序数组却不一定了，它需要在指定的位置插入。
 *  2、查找慢：当然如果根据下标查找是很快的，但是通常都是根据元素值来查找的，给定一个元素值，对于无序数组，我们需要从数组第一个元素开始遍历，直到找到元素。
 *  有序数组通过特定的算法（冒泡、快速、选择、插入...）查找的速度会比无序数组块。
 *  3、删除慢：根据元素值删除，我们要先找到该元素所处的位置，然后将元素后面的值整体往前面移动一个位置。也需要比较多的时间。
 *  4、数组一旦创建固定长度后，不能动态扩展数组的元素个数。如果初始化一个很大的数组大小，浪费内存空间，如果给小了，后面数据增加又添加不进去。
 *
 * @author pengweiqiang
 * @create 2018/11/13
 * @since 1.0.0
 */
public class Array {
    private int [] intArray;

    //定义数组的实际有效长度
    private int elems;
    //顶一个数组的最大长度
    private int length;

    /**
     * 默认构造一个长度为50的数组
     */
    public Array(){
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    /**
     * 构造函数，初始化一个长度为Length的数组
     * @param length
     */
    public Array(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    /**
     * 获取数组的有效长度
     * @return
     */
    public int getSize(){
        return elems;
    }

    /**
     * 遍历显示元素
     */
    public void display(){
        for(int i = 0;i<elems;i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * 添加元素
     *
     * @param value 假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响
     * @throws Exception
     */
    public void add(int value) throws Exception {
        if(elems==length){
            throw new Exception("超过数组长度");
        }
        intArray[elems] = value;
        elems++;
    }

    /**
     * 根据下标获取元素
     * @param index
     * @return 查找下标值在数组下标有效范围内，返回下标所表示的元素
     *          查找下标超出数组下标有效值，提示访问下标越界
     */
    public int get(int index) throws Exception{
        if(index<0 || index > elems){
            throw new Exception("访问下标数组越界");
        }
        return intArray[index];
    }

    /**
     * 查找元素
     * @param searchValue
     * @return 查找的元素如果存在返回下标值，如果不存在，返回 -1
     */
    public int find(int searchValue){
        int searchIndex = -1;
        for(int i = 0 ;i<elems;i++){
            if(intArray[i] == searchValue){
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    /**
     * 删除元素
     * @param value
     * @return 如果要删除的值不存在，直接返回false,否则返回true,删除成功
     */
    public boolean delete(int value){
        int index = find(value);
        if(index == -1){
            return false;
        }
        if(index == elems-1){//元素在末尾，直接删除
            elems --;
        }else{
            for(int i = index;i<elems-1;i++){
                intArray[i]=intArray[i+1];
            }
            elems -- ;
        }
        return true;
    }

    /**
     *
     * @param oldValue
     * @param newValue
     * @return 修改成功返回true，修改失败返回false
     */
    public boolean modify(int oldValue,int newValue){
        int index = find(oldValue);
        if(index == -1){
            return false;
        }
        intArray[index] = newValue;
        return true;
    }

    public static void main(String []args) throws Exception {
        Array array = new Array(5);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        //显示数组元素
        array.display();

        //查找下标为0的元素
        int value = array.get(0);
        System.out.println(value);

        //删除4的元素
        boolean isDelete = array.delete(4);
        System.out.println(isDelete);
        array.display();

        //将元素3改成33
        array.modify(3,6);
        array.display();
    }


}