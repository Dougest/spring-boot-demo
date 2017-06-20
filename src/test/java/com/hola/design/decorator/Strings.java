package com.hola.design.decorator;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;


public final class Strings implements Serializable,Comparable<Strings>, CharSequence{
	
	private static final long serialVersionUID = 2555740322621991219L;
	//字符仓库
	private final char value[];
	private int hash;
	/**
	 *	字符串是一个特殊的 被对象流协议包装的类 
	 *	也就是用来写成UTF格式的编码
	 */
	public static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];
	
	public Strings (){
		this.value = new char[0];
	}
	
	 public Strings(String str) {
		 this.value = str.toCharArray();
	 }
	
	/**
	 * 初始化一个最近的字符串对象 代表这个对象和参数是相同的一串字符序列 
	 * 这些字中 创建的字符串从复制自参数
	 * 除非复制字符原型是必要的
	 * 当字符串使不变的时候没有必要用这个构造器
	 * @param original
	 */
	public Strings(Strings original) {
		this.value = original.value;
		this.hash = original.hash;
	}
	/**
	 * 分配一个新的String代码
	 * 这样就代表着  序列化的字符 一般包含在一个数组参数里面
	 * 这个内容是字符数组的复制品
	 * 字符数组后来的改动不影响新的字符串对象
	 */
	public Strings(char value[]) {
		this.value = Arrays.copyOf(value, value.length);
	}
	
	/**
	 * 从字符参数子数组中分配一个字符串
	 * @param value
	 * @param offset
	 * @param count
	 */
	public Strings(char value[], int offset, int count) {
		if(offset < 0) {
			throw new RuntimeException(offset+"小于0");
		}
		if(count < 0) {
			throw new RuntimeException(count+"小于0");
		}
		if(offset < value.length - count) {
			throw new RuntimeException("不合理的参数: "+count+offset);
		}
		this.value = Arrays.copyOfRange(value, offset, offset+count);
	}
	
	public Strings(char[] value, boolean share) {
	        this.value = value;
	 }
	 
	 public Strings(StringBuilder builder) {
		 String str = builder.toString();
		 char[] strChar = str.toCharArray();
	     this.value = Arrays.copyOf(strChar, builder.length());
	  }
	
	
	 
    public Strings(StringBuffer buffer) {
        synchronized(buffer) {
            this.value = Arrays.copyOf(buffer.toString().toCharArray(), buffer.length());
        }
    }
	 
	public int length() {
		return value.length;
	}

	public char charAt(int index) {
		if(index < 0 || index > value.length) {
			throw new RuntimeException("不合理的坐标,实际长度: "+value.length+" 你的位置"+index);
		}
		return value[index];
	}
	
	/**
	 * 截取字符串
	 * @param start
	 * @param end
	 * @return
	 */
	 public Strings subString(int start, int end){
		 if(start < 0) throw new RuntimeException("起始位置错误");
		 if(end > value.length) throw new RuntimeException("结束位置过长");
		 int subLength = end - start;
		 if(subLength < 0) throw new RuntimeException("结束位置不能大于起始位置");
		 return ((start == 0) && (end == value.length)) ? this : new Strings(value, start, subLength);
	 }
	 
	 
	public CharSequence subSequence(int start, int end) {
		return this.subString(start, end);
	}
	
	
	public int compareTo(Strings otherStrings) {
		int length1 = value.length;
		int length2 = otherStrings.value.length;
		int limit = Math.min(length1, length2);
		char v1[] = value;
		char v2[] = otherStrings.value;
		int k = 0;
		while(k < limit) {
			char c1 = v1[k];
			char c2 = v2[k];
			if(c1 != c2) return c1 - c2;
		}
		k++;
		return length1 - length2;
	}
	/**
	 * java语言的关键字，变量修饰符，如果用transient声明一个实例变量，
	 * 当对象存储时，它的值不需要维持。换句话来说就是，用transient关键字
	 * 标记的成员变量不参与序列化过程
	 */
	private transient int hash32 = 0;
	
//	public static Strings ValuesOf(Object o) {
//		o.getClass().cl
//		return FloatingDecimal(d).toJavaFormatString();
//	}
	   public boolean startsWith(Strings prefix, int toffset) {
		 //  prefix = new Strings();
	        char ta[] = value;
	        int to = toffset;
	        char pa[] = prefix.value;
	        int po = 0;
	        int pc = prefix.value.length;
	        // Note: toffset might be near -1>>>1.
	        if ((toffset < 0) || (toffset > value.length - pc)) {
	            return false;
	        }
	        while (--pc >= 0) {
	            if (ta[to++] != pa[po++]) {
	                return false;
	            }
	        }
	        return true;
	    }
	   public boolean startsWith(Strings prefix) {
	        return startsWith(prefix, 0);
	   }
	   public boolean startsWith(String prefix, int toffset) {
		   		Strings strs = new Strings(prefix);
		        char ta[] = value;
		        int to = toffset;
		        char pa[] = strs.value;
		        int po = 0;
		        int pc = strs.value.length;
		        if ((toffset < 0) || (toffset > value.length - pc)) {
		            return false;
		        }
		        while (--pc >= 0) {
		            if (ta[to++] != pa[po++]) {
		                return false;
		            }
		        }
		        return true;
		    }
	   public boolean startsWith(String prefix) {
	        return startsWith(prefix, 0);
	    }
	   
	   public boolean endsWith(Strings suffix) {
	        return startsWith(suffix, value.length - suffix.value.length);
	    }
}
