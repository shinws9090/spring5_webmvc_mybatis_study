package spring5_webmvc_mybatis_study.mapper;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_webmvc_mybatis_study.config.ContextRoot;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class MemberMapperTest {

	
	@Autowired
	MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testInsert() {
//		mapper.insert(new Member("sadsad", "sdfsdf", "sdjhfskd", LocalDateTime.now()));
	}

	@Test
	public void testSelectByEmail() {
		System.out.println(mapper.selectByEmail("test@test.co.kr"));
	}
	@Test
	public void testSelectListBy() {
	}

}
