package com.koreait.spring;

import java.util.Iterator;
import java.util.Set;

public class SetHandler {
	
	private Set<String> set;
	
	public SetHandler() {}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	public void setInfo() {
		// Set 순회1
		// for(String item : set) {
		// 	System.out.println(item);
		// }
		// Set 순회2
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
