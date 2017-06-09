/**
 * 
 */
package com.base.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Think
 *
 */
public class AuthUserDetailsService implements UserDetailsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// ���ݿ��ѯ��ѯ�û�

		// ����û������ڣ��׳�UsernameNotFoundException�쳣

		// ��ȡȨ�޽�ɫ�б�
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// �����û�return new
		// User(myuser.getUsername,myuser.getPassword,authorities)
		return new User(username, "password", authorities);
	}

}
