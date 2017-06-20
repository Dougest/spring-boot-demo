package com.hola.design.strategy;
/**
 * 角色类
 * @author Dougest
 * 2017年5月26日   下午1:28:36
 *
 */
public abstract class Character {
	protected  WeaponBehavior Weapon;
	
	
	abstract void fight();
}
