package ex01_oop;

class Watch {
	int hour;
	int min;
	int sec;
	
	Watch(int hour, int min, int sec) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	void addHour(int hour) {
		if(hour < 0) {
			return;
		}
		this.hour += hour;
		this.hour %= 24;
	}
	void addMinute(int min) {
		if(min < 0) {
			return;
		}
		this.min += min;
		int hMin = this.min / 60;
		this.min %= 60;
		addHour(hMin);
	}
	void addSecond(int sec) {
		if(sec < 0) {
			return;
		}
		this.sec += sec;
		int mSec = this.sec / 60;
		this.sec %= 60;
		addMinute(mSec);
	}
	void see() {
		System.out.println(hour + "시 " + min + "분 " + sec + "초");
	}
}

public class Ex01_Watch {

	public static void main(String[] args) {

		Watch watch = new Watch(16, 15, 30);
		
		watch.addHour(25);		// 25시간 후 (1시간)
		watch.addMinute(61);	// 61분 후 (1시간 1분)
		watch.addSecond(3661);	// 3661초 후 (1시간 1분 1초)
		
		watch.see();			// 19시 17분 31초
		
	}

}
