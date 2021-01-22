package ex02_pakage;

import ex01_pakage.Father;

// Father 클래스의 서브클래스
public class Baby extends Father {

	void info() {
		// System.out.println(secret);	// private
		// System.out.println(tv);	// default : ex01_pakage 에서만 볼 수 있다
		System.out.println(perID);
		System.out.println(name);
	}

}