package com.hola.dao.ztahti;

import org.apache.ibatis.annotations.Mapper;

import com.hola.entity.ztahti.Account;
@Mapper
public interface AccountDao {
	public Account findAccounts(Long id);
	public Account findAccount(Account account);
	public void addAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccounts(Long id);
	public void deleteAccount(Account account);
	
}
