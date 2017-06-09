/**
 * 
 */
package com.base.user.repo;

import org.springframework.stereotype.Repository;

import com.base.user.domain.UserInfo;

/**
 * @author Think
 *
 */
@Repository
public interface UserMapper {

	public UserInfo getUserInfoByName(String name);
}
