package ch05.ex03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository		// @Component의 특수한 경우로(scan 대상) CRUD 연산을 제공하는 DAO 클래스에 주로 사용
public class MyUserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;	// JdbcTemplate bean 객체에 대한 dependency injection
	
	public List<MyUserDTO> list() {
		String query = "select * from myuser";
		List<MyUserDTO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
									 // Connection 과정 및 try-catch 문을 제거
		return list;
	}
}

