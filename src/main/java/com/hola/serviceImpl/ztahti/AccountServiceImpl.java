package com.hola.serviceImpl.ztahti;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hola.dao.ztahti.AccountDao;
import com.hola.entity.ztahti.Account;
import com.hola.service.ztahti.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	@Resource
	private AccountDao accountDao;
	@Override
	public Account findAccount(Long id) {
		// TODO Auto-generated method stub
		return accountDao.findAccounts(id);
	}

	@Override
	public Account findAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.findAccount(account);
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.addAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(account);
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		accountDao.deleteAccounts(id);
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.deleteAccount(account);
	}

}
