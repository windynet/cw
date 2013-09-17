package cw.test.elasticsearch;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cw.search.elasticsearch.SearchService;
import cw.service.ArticleService;
import cw.test.BaseTest;

public class ElasticsearchTest extends BaseTest{
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	ArticleService articleService;


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndexArticles() {
		try {
			//searchService.deleteIndex();
			searchService.openIndex();
			
			searchService.indexArticles( articleService.queryAllArticles() );
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}finally{
			try {
				searchService.closeIndex();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//fail("Not yet implemented");
	}

}