/**
 * 
 */
package com.base.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.base.user.domain.UserInfo;

/**
 * @author Think
 *
 */
@Service
public class SecurityService {

	/**
	 * 此例子不可用
	 * 
	 * @param name
	 * @return
	 */
	@PostAuthorize("returnObject.username==principal.username")
	public UserInfo getUserInfo(String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(name);
		return userInfo;
	}

	/**
	 * 此例子亦不可用
	 * 
	 * @return
	 */
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@PostFilter("hasRole('ROLE_ADMIN')||filterobject.userInfo.username==principal.username")
	public List<UserInfo> getUserInfos() {
		List<UserInfo> result = new ArrayList<UserInfo>();
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUsername("user");
		result.add(userInfo1);

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUsername("admin");
		result.add(userInfo2);

		UserInfo userInfo3 = new UserInfo();
		userInfo3.setUsername("test");
		result.add(userInfo3);

		return result;
	}

}
