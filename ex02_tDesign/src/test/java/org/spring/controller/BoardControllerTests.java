package org.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

// Junit테스트 진행시 Spring의 테스트 컨텍스를 로드(스프링 프로젝트의 구조 적용)
@RunWith(SpringJUnit4ClassRunner.class)
// 테스트에 필요한 Spring관련 설정파일 로드
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//웹 애플리케이션 컨텍스트 설정 (화면단이 필요할때)
@WebAppConfiguration
// Lombok을 사용한 로그 출력
@Log4j
public class BoardControllerTests {
	// 의존성 주입 : BoardControllerTests는 WebApplicationContext가 꼭 필요.
	@Autowired
	private WebApplicationContext ctx;
	// 목업: 테스트용 결과를 표현하는 객체(실제로 구현X)
	private MockMvc mockMvc;
	
	// 각 테스트 메서드가 실행되기 전 자동 호출
	@Before
	public void setup() {
		// mockMvc객체 생성 (화면은 webAppContextSetup에 생성되야한다.)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	// 해당 URI에 메서드가 정상적으로 동작하는 테스트
	@Test
	public void testRegister() throws Exception {
		log.info(
					// http 요청 수행
			mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "업데이트 테스트") // 기능 수행을 위한 각 파라미터 전달
					.param("content", "업데이트 테스트 컨텐츠")
					.param("writer", "test01"))
			.andReturn()); // 수행한 요청에 대한 결과 반환.
	}
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
					.andReturn().getModelAndView().getModelMap());
			
	}
	
	
}
