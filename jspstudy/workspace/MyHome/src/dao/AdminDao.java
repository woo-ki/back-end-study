package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDto;
import mybatis.config.DBService;

public class AdminDao {
	private SqlSessionFactory factory;
	
	public AdminDao() {
		factory = DBService.getInstance().getFactory();
	}
	
	private static AdminDao boardDao = new AdminDao();
	public static AdminDao getInstance() {
		return boardDao;
	}
	
	public int getTotalMemberCount() {
		SqlSession ss = factory.openSession();
		int totalMemberCount = ss.selectOne("mybatis.mapper.admin.getTotalMemberCount");
		ss.close();
		return totalMemberCount;
	}
	
	public List<MemberDto> adminMemberList(Map<String, Integer> map) {
		SqlSession ss = factory.openSession();
		List<MemberDto> list = ss.selectList("mybatis.mapper.admin.adminMemberList", map);
		ss.close();
		return list;
	}
	
	public int adminMemberBoardDelete(String mId) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("mybatis.mapper.admin.adminMemberBoardDelete", mId);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int adminMemberDelete(int mNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("mybatis.mapper.admin.adminMemberDelete", mNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int adminMemberUpdate(MemberDto memberDto) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("mybatis.mapper.admin.adminMemberUpdate", memberDto);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}