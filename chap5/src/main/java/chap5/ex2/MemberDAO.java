package chap5.ex2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public int updateMember(MemberVO member) {
		String query = "update member set name=?,password=?,email=?,regdate=? where id =?";
		return template.update(query, member.getName(), member.getPassword(), 
				member.getEmail(), member.getRegdate(),member.getId());
	}
	
	public int addMember(MemberVO member) {
		String query = "insert into member(name, password, email, regdate) values (?, ?, ?, ?)";
		return template.update(query, member.getName(), member.getPassword(), 
				member.getEmail(), member.getRegdate());
	}
	
	public MemberVO getMember(String id) {

		String sql = "select * from member where id = ?";
		
		MemberVO selectedMember = template.queryForObject(sql,(rs, rowNum)-> new MemberVO(rs.getInt("id"),
				rs.getString("email"),rs.getString("password"),rs.getString("name"),rs.getString("regdate")),new Object[] {id});
		
		return selectedMember;
	}
	
	public MemberVO getMemberByEmail(String email) {
		try {

		String sql = "select * from member where email = ?";
		
		MemberVO selectedMember = template.queryForObject(sql,(rs, rowNum)-> new MemberVO(rs.getInt("id"),
				rs.getString("email"),rs.getString("password"),rs.getString("name"),rs.getString("regdate")),new Object[] {email});
		//람다식을 사용하면서 MemberVO 객체에 값을 초기화해주는 느낌 lombok @AllArgsConstructor 전체 인자 생성자를 선언했으므로, NoArgsConstructor또한 필요 
		return selectedMember;
		}catch(Exception e) {
			return null;
		}
	}
	
	public int deleteMember(String id) {
		String query = "delete from member where id = ?";
		return template.update(query, id);
	}
}
