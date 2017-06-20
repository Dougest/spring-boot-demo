package com.hola.controller.ztahti;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hola.service.ztahti.AccountService;

@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
public class AccountController {
	@Resource
	private AccountService accountService;
}
