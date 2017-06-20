package com.hola.design.strategy;
/**
 * 召唤师峡谷
 * @author Dougest
 * 2017年5月26日   下午1:30:28
 *
 */
public class ZhaoHuanShiXiaGu {
	public static void main(String[] args) {
		Zhaoxin z = new Zhaoxin();
		z.fight();
		Galen g = new Galen();
		g.fight();
	}
}
