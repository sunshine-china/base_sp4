/**
 * 
 */
package com.base.test.service;

import java.util.List;

import com.base.test.domain.DemoBean;

/**
 * @author Think
 *
 */
public interface IRMIService {

	List<DemoBean> getDemoBeans();

	void saveDemoBean(DemoBean demoBean);

	DemoBean getDemoBean(int id);
}
