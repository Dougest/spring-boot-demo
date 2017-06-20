package com.hola.jdkcopy;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/**
 * 老张的翻译水平有限
 * @author Dougest
 * 2017年6月20日   下午5:39:09
 *
 * @param <T>
 */
public class ArrayList<T> extends AbstractList<T>  
implements List<T>,RandomAccess,Cloneable,Serializable{
	private static final long serialVersionUID = 3379427505313069860L;
	/**
	 * 默认容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	/**
	 * 空实例数组用作实例化
	 */
	private static final Object[] EMPTY_ELEMENTDATA = {};
	/**
	 * 用于默认大小的空实例的共享空数组实例。我们他从EMPTY_ELEMENTDATS区分以知道在元素添加的时候扩容
	 */
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	/**
	 * 将数组的元素存储在数组中,ArrayList的容量是这个数组缓冲区的长度
	 * 当第一个元素添加时,任何带有elementData==default容量空元素的空ArrayList
	 * 将被扩展到DEFAULT_CAPACITY的容量当添加第一个元素时
	 * 看不懂可以看下面第一个构造器
	 */
	transient Object[] elementData;//没有被私有化是为了简化内部类访问
	
	private int size;//数组内元素真实个数
	
	/*****构造器时间*******/
	//初始化容量的构造器
	public ArrayList(int initCapacity){
		if(initCapacity > 0) 
			this.elementData = new Object[initCapacity];
		else if(initCapacity == 0) 
			this.elementData = EMPTY_ELEMENTDATA;
		else 
			throw new IllegalArgumentException("cant init ArrayList for this initCapacity:"+initCapacity);
	}
	/*默认构造器*/
	public ArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
	/**
	 * 出入继承集合类的实例
	 * @param c
	 */
	public ArrayList(Collection<? extends T> c) {
		elementData = c.toArray();
		if((size = elementData.length) != 0){
			if(elementData.getClass() != Object[].class)
				elementData = Arrays.copyOf(elementData, size,Object[].class);
		} else {
			this.elementData = EMPTY_ELEMENTDATA;
		}
	}
	
	/*******************************方法区***************************************/
	/**
	 * 由于初始化的ArrayList容量默认为10,超过10按1.5倍增加,所以需要trim
	 */
	public void trimToSize() {
		modCount++;//来自父类AbstractList中的属性
		if(size < elementData.length) 
			elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
	}
	/*确认容量*/
	public void ensureCapacity(int minCapacity) {
		//最小扩展
		int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0: DEFAULT_CAPACITY;
		
		if(minCapacity > minExpand) ensureExplicitCapacity(minCapacity);
	}
	/**
	 * 确认容量内部
	 * @param minCapacity
	 */
	public void ensureCapacityInternal(int minCapacity) {
		if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) 
			//取值 10 - 0之间最大,还是10咯,不知道这行代码的意图
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
			
		ensureExplicitCapacity(minCapacity);
	}
	/**
	 * 明确容量
	 * @param minCapacity
	 */
	public void ensureExplicitCapacity(int minCapacity){
		modCount++;
		//意识到溢出时
		if(minCapacity - elementData.length > 0)
			grow(minCapacity);
	};
	/*最大数组长度*/
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	/**
	 * 数组长度加一半
	 * @param minCapacity
	 */
	public void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if(newCapacity - minCapacity < 0) //小于最小长度时
			newCapacity = minCapacity;
		if(newCapacity - MAX_ARRAY_SIZE > 0) //大于integer的长度限制(21亿4千万)
			newCapacity = hugeCapacity(minCapacity);
		
		 elementData = Arrays.copyOf(elementData, newCapacity);
	};
	//无限容量 名字霸气
	 private static int hugeCapacity(int minCapacity) {
	        if (minCapacity < 0) // overflow 超出int整数范围变负数
	            throw new OutOfMemoryError();
	        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE :  MAX_ARRAY_SIZE;
	 }
	 //我现在好奇size怎么来的
	 public boolean isEmpty() {
		 return size == 0;
	 }
	 
	 public boolean contains(Object o) {
		 		//父类也有的方法,下面有自己的实现
		 return indexOf(o)>0;
	 }
	//感觉方法有点坑 null的话在数组里不知一个的话返回最先遍历到的,仔细一想也没毛病
	 public int indexOf(Object o) {
		 if(o == null) {
			 for(int i = 0; i < size; i++) 
				 if(elementData[i] == null) 
					 return i;
		 } else {
			 for(int i = 0; i < size; i++) 
				 if(o.equals(elementData[i])) 
					 return i;
		 }
		 return -1;
	 }
	 //倒过来遍历
	 public int lastIndexOf(Object o) {
	        if (o == null) {
	            for (int i = size-1; i >= 0; i--)
	                if (elementData[i]==null)
	                    return i;
	        } else {
	            for (int i = size-1; i >= 0; i--)
	                if (o.equals(elementData[i]))
	                    return i;
	        }
	        return -1;
	    }
	 //浅度克隆
	 public Object clone() {
	        try {
	            ArrayList<?> v = (ArrayList<?>) super.clone();
	            v.elementData = Arrays.copyOf(elementData, size);
	            v.modCount = 0;
	            return v;
	        } catch (CloneNotSupportedException e) {
	            throw new InternalError(e);
	        }
	    }
	 //底层是数组的好处
	 public Object[] toArray() {
		 return Arrays.copyOf(elementData, size);
	 }
	 //数组转数组???what`s the fuck??
	 @SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		 if(a.length < size)//小于ArrayList长度,正常数组复制方法
			 return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		 System.arraycopy(elementData, 0, a, 0, size);//???what`s the fuck??
		 if(a.length > size)//数组长度大于ArrayList长度
			 a[size] = null;//???what`s the fuck??
		 return a;
	 }
	 //what`s the fuck??
	 @SuppressWarnings("unchecked")
	T elementData(int index){
		 return (T) elementData[index];
	 }
	 
	 private String outOfBoundsMsg(int index) {
	        return "Index: "+index+", Size: "+size;
	    }
	 //范围检测
	 public void rangeCheck(int index) {
		 if(index >= size) {
			 throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		 }
	 }
	  private void rangeCheckForAdd(int index) {
	        if (index > size || index < 0)
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	    }

	 
/****************************AbstractList 抽象方法实现区***********************************/
	public T get(int index) {
		rangeCheck(index);
		return elementData(index);
	}

	public int size() {
		return size;
	}
/*****************************重头戏来了,常用的方法************************************/
	//返回了被替换的值,我要思考下
	public T set(int index, T element) {
		 rangeCheck(index);
		 
		 T oldValue = elementData(index);
		 elementData[index] = element;
		 return oldValue;
	}
	//竟然是这种方式添加元素的,震惊了
	public boolean add(T t) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = t;
		return true;
	}
	
	public void add(int index, T element) {
		rangeCheckForAdd(index);
		ensureCapacityInternal(size + 1);  // 增加容量
		//what`s this
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		
		elementData[index] = element;
	    size++;//??为什么又加了
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
