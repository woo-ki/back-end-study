package ex02_object_array;

import java.util.Scanner;

// 하루
class Day {
	// field
	String schedule;	// 기본값 null
	// constructor
	Day() {	}
	// method
	// 1. 스케쥴 확인
	String getSchedule() {
		return schedule;
	}
	// 2. 스케쥴 저장
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	// 3. 스케쥴 출력
	void printDaySchedule() {
		if(schedule == null || schedule.isEmpty()) {
			System.out.println("없음.");
		} else {
			System.out.println(schedule);
		}
	}
}

// 일주일 스케쥴
class WeekScheduler {
	// field
	int nthWeek;	// 1주차 ~ n주차
	Day[] week;
	String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
	Scanner sc;
	// constructor
	WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		// week 배열의 길이를 7로 결정하기
		week = new Day[weekName.length];
		// Day 객체 7개 생성해 두기
		for(int i = 0; i < week.length; i++) {
			week[i] = new Day();
		}
		// sc 생성하기
		sc = new Scanner(System.in);
	}
	// method
	// 1. 스케줄 만들기 (스케줄이 없으면 만들고, 있으면 동작 취소)
	void makeScedule() {
		boolean isExist = false;	// 입력한 요일이 있으면 true 없으면 false
		System.out.print("스케쥴을 등록할 요일(일~토) 입력 >>> ");
		String day = sc.next();
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(day.equals(weekName[i])) {
				if(week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.print("스케쥴 입력 >>> ");
					week[i].setSchedule(sc.nextLine());
					System.out.println(weekName[i] + "요일에 새 스케쥴이 저장되었습니다.");
				} else {
					System.out.println(weekName[i] + "요일은 이미 스케쥴이 있습니다.");
				}
				isExist = true;
				break;
			}
		}
		if(!isExist) {
			System.out.println(day + "요일은 존재하지 않습니다.");
		}
	}
	// 2. 스케쥴 수정하기 (기존 스케쥴이 있으면 수정, 없으면 새로 등록)
	void changeSchedule() {
		boolean isExist = false;
		System.out.print("스케쥴을 수정할 요일(일~토) 입력 >>> ");
		String day = sc.next();
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(day.equals(weekName[i])) {
				if(week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.println(weekName[i] + "요일은 스케쥴이 없습니다.");
					System.out.print("새 스케쥴을 등록하겠습니까(Y/N)? >>> ");
					String yOrN = sc.next();
					sc.nextLine();
					if(yOrN.equalsIgnoreCase("Y")) {
						System.out.print("새 스케쥴 입력 >>> ");
						week[i].setSchedule(sc.nextLine());
						System.out.println(weekName[i] + "요일에 새 스케쥴이 저장되었습니다.");
					} else {
						System.out.println("취소 되었습니다.");
					}
				} else {
					System.out.println("수정할 스케쥴을 확인합니다.");
					System.out.println(week[i].getSchedule());
					System.out.print("수정할까요(Y/N)? >>> ");
					String delete = sc.next();
					sc.nextLine();
					if(delete.equalsIgnoreCase("Y")) {
						System.out.print("수정할 스케쥴 입력 >>> ");
						week[i].setSchedule(sc.nextLine());
						System.out.println(weekName[i] + "요일의 스케쥴이 수정되었습니다.");
					} else {
						System.out.println(weekName[i] + "요일의 스케쥴이 유지됩니다.");
					}
				}
				isExist = true;
				break;
			}
		} // end for
		if(!isExist) {
			System.out.println(day + "요일은 존재하지 않습니다.");
		}
	}
	// 3. 스케쥴 삭제하기 (기존 스케쥴이 있으면 삭제, 없으면 동작 취소)
	void deleteSchedule() {
		boolean isExist = false;
		System.out.print("스케쥴을 삭제할 요일(일~토) 입력 >>> ");
		String day = sc.next();
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(day.equals(weekName[i])) {
				if(week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.println(weekName[i] + "요일은 스케쥴이 없습니다.");
				} else {
					System.out.println("삭제할 스케쥴을 확인합니다.");
					System.out.println(week[i].getSchedule());
					System.out.print("삭제할까요(Y/N)? >>> ");
					String delete = sc.next();
					sc.nextLine();
					if(delete.equalsIgnoreCase("Y")) {
						week[i].setSchedule(null);
						System.out.println(weekName[i] + "요일의 스케쥴이 삭제되었습니다.");
					} else {
						System.out.println(weekName[i] + "요일의 스케쥴이 유지됩니다.");
					}
				}
				isExist = true;
				break;
			}
		}	// end for
		if(!isExist) {
			System.out.println(day + "요일은 존재하지 않습니다.");
		}
	}
	// 4. 일주일 전체 스케쥴 출력하기 (요일별 스케쥴 출력)
	void printWeekSchedule() {
		System.out.println(nthWeek + "주차 스케쥴 안내");
		for(int i = 0; i < week.length; i++) {
			System.out.print(weekName[i] + "요일: ");
			week[i].printDaySchedule();
		}
	}
	// 5. 프로그램 종료
	void exit() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	// 6. 메뉴 출력
	void menu() {
		System.out.println();
		System.out.println("1. 스케쥴 만들기");
		System.out.println("2. 스케쥴 삭제하기");
		System.out.println("3. 스케쥴 변경하기");
		System.out.println("4. 스케쥴 전체 출력하기");
		System.out.println("0. 프로그램 종료");
		System.out.println();
	}
	// 7. 스케쥴러 실행
	void run() {
		while(true) {
			menu();		// 메뉴 출력
			System.out.print("메뉴 선택 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();	// Enter 읽어서 버리기
			
			switch(choice) {
			case 1 : makeScedule(); break;	// break는 switch문 종료
			case 2 : deleteSchedule(); break;
			case 3 : changeSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : exit(); return;
			default : System.out.println("없는 메뉴입니다. 다시 입력하세요.");
			}
		}
	}
}

public class Ex05_Scheduler {

	public static void main(String[] args) {

		WeekScheduler firstWeek = new WeekScheduler(1);
		firstWeek.run();
		
	}

}
