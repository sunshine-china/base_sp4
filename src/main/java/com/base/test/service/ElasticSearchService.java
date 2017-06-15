/**
 * 
 */
package com.base.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Think
 *
 */
@Service
public class ElasticSearchService {

	@Autowired
	private ElasticsearchTemplate template;

	public void test() {
		
	}
}
