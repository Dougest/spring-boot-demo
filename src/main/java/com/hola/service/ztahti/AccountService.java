package com.hola.service.ztahti;

import com.hola.entity.ztahti.Account;

public interface AccountService {
	public Account findAccount(Long id);
	public Account findAccount(Account account);
	public void addAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Long id);
	public void deleteAccount(Account account);
}
