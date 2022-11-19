package ch05.ex04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate template;
	
	public List<MemberVO> listMembers() {		
		String sql = "select * from member order by id";
		List<MemberVO> list = template.query(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		return list;
	}
	
	public int addMember(MemberVO member) {
		String query = "insert into member(name, password, email, regdate) values (?, ?, ?, ?)";
		return template.update(query, member.getName(), member.getPassword(), 
				member.getEmail(), member.getRegdate());
	}
	
	public int deleteMember(String id) {
		String query = "delete from member where id = ?";
		return template.update(query, id);
	}
}
