package com.hola.design.strategy;
/**
 * 赵信
 * @author Dougest
 * 2017年5月26日   下午1:26:06
 *
 */
public class Zhaoxin extends Character{
	void fight() {
		WeaponBehavior Weapon = new Qiang();
	//	Weapon = new Qiang();
		Weapon.weapon();
	}
}
