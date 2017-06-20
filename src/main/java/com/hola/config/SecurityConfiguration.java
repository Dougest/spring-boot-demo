package com.hola.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private SecuritySettings settings;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").permitAll().successHandler(null )
		.and().authorizeRequests().antMatchers("*.png","*.img","*.css","*.js").permitAll()
		.antMatchers(settings.getPermitall().split(",")).permitAll()
		.anyRequest().authenticated()
		.and().csrf().requireCsrfProtectionMatcher(null)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
		.and().logout().logoutSuccessUrl(settings.getLogoutsuccessurl())
		.and().exceptionHandling().accessDeniedPage(settings.getDeniedpage())
		.and().rememberMe().tokenValiditySeconds(60*60*24*7).tokenRepository(null);
	}
	
}
@ConfigurationProperties(prefix="")
class SecuritySettings{
	
	private String logoutsuccessurl = "/logout";//定义成功退出的链接
	private String permitall = "/api";//允许访问的url列表
	private String deniedpage = "/deny";//拒绝访问的信息提示链接
	private String urlroles;//权限管理规则 链接地址与角色权限的配置列表
	public String getLogoutsuccessurl() {
		return logoutsuccessurl;
	}
	public void setLogoutsuccessurl(String logoutsuccessurl) {
		this.logoutsuccessurl = logoutsuccessurl;
	}
	public String getPermitall() {
		return permitall;
	}
	public void setPermitall(String permitall) {
		this.permitall = permitall;
	}
	public String getDeniedpage() {
		return deniedpage;
	}
	public void setDeniedpage(String deniedpage) {
		this.deniedpage = deniedpage;
	}
	public String getUrlroles() {
		return urlroles;
	}
	public void setUrlroles(String urlroles) {
		this.urlroles = urlroles;
	}
	
	
}