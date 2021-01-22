package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.PersonDto;

public class PersonCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		char gender = request.getParameter("gender").charAt(0);
		String[] interests = request.getParameterValues("interests");
		
		/**** dto ****/
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setAge(age);
		personDto.setAddress(address);
		personDto.setGender(gender);
		personDto.setInterests(interests);
		
		// 1. request에 personDto 저장하기
		request.setAttribute("personDto", personDto);
		
		// 2. session에 personDto 저장하기
		// 모든 Command는 HttpSession타입의 session을 request로부터 얻어낸 뒤 사용해야 한다.
		HttpSession session = request.getSession();
		session.setAttribute("personDto", personDto);
		
		/**** Map ****/
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("age", age);
		personMap.put("address", address);
		personMap.put("gender", gender);
		personMap.put("interests", interests);
		
		// 1. request에 poersonMap 저장하기
		request.setAttribute("personMap", personMap);
		// 2. session에 poersonMap 저장하기
		session.setAttribute("personMap", personMap);
		
		/**** ArrayList ****/
		List<PersonDto> personList = new ArrayList<PersonDto>();
		for(int i = 0; i < 10; i++) {
			PersonDto pDto = new PersonDto();
			pDto.setName(name);
			pDto.setAge(age);
			pDto.setAddress(address);
			pDto.setGender(gender);
			pDto.setInterests(interests);
			personList.add(pDto);
		}
		
		request.setAttribute("personList", personList);
		return "view/output.jsp";
	}

}
