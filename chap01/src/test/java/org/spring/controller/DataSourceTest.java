package org.spring.controller;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {
    
    @Autowired(required = false)
    private DataSource ds;
    
    @Autowired(required = false)
    private SqlSessionFactory ssf;
    
    @Test
    public void dataSourceTest() {
        try (Connection con = ds.getConnection()) {
            log.info("Connection obtained successfully: " + con);
        } catch (Exception e) {
            log.error("Error obtaining connection from DataSource", e);
            e.printStackTrace();
        }
    }
    @Test
    public void TestMyBatis() {
        try (SqlSession session = ssf.openSession(); Connection con=session.getConnection()) {
            log.info("Connection obtained successfully: " + session);
            log.info("Connection obtained successfully: " + con);
        } catch (Exception e) {
            log.error("Error obtaining connection from DataSource", e);
            e.printStackTrace();
        }
    }
}

