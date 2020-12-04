package myBank;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		// 은행 API사용시 난수 값으로 많이 사용된다.
		Date today = new Date();
		long ldate = today.getTime();
		System.out.println(ldate);
		long cdate = System.currentTimeMillis();
		System.out.println(cdate);

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));	//일자
		System.out.println(cal.get(Calendar.MONTH)); //0~부터 시작해서 +1해야 현재 month.
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));	//일1, 월2, 화3, 수4, 목5, 금6, 토7

		/* Date(), getInstance() 차이점 메모리
		 * Date()는 계속 new객체로 만들지만, 
		 * getInstance()는static영역에 생성해놓고 가져와 사용.
		*/
		 
		//날짜계산
		LocalDate ld = LocalDate.now();
		System.out.println("100일뒤 : " + ld.plusDays(100)); //사귄지 100일 되는날
		
		//시간계산
		LocalTime lt = LocalTime.now();
		System.out.println("100분뒤: " + lt.plusMinutes(100));
		
		//두 날짜,시간 사이 간격 계산: period
		
		
		
		
	}

}
