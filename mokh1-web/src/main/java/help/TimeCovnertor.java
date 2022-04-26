package help;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeCovnertor {
	
	private static Date jalali_to_gregorian(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		System.err.println("year:" + gy);
		System.err.println("month:" + gm);
		System.err.println("day:" + gd);
		// Date date=new Date(gy,gm,gd);
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public static Date mohlateEjareChangeDate(String inp) {
		try {
		String test = inp;
		String arr[] = test.split("/");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		System.err.println(ans);
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}
		System.err.println(yearstr);

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}
		System.err.println(monthstr);

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}
		System.err.println(daystr);

		return jalali_to_gregorian(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));
		}catch(Exception x) {
			return null;
		}
	}
	
	
	 private static String gregorian_to_jalali(int gy, int gm, int gd) {
			String text2 = "";
			int[] g_d_m = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
			int jy;
			if (gy > 1600) {
				jy = 979;
				gy -= 1600;
			} else {
				jy = 0;
				gy -= 621;
			}
			int gy2 = (gm > 2) ? (gy + 1) : gy;
			int days = (365 * gy) + ((int) ((gy2 + 3) / 4)) - ((int) ((gy2 + 99) / 100)) + ((int) ((gy2 + 399) / 400)) - 80
					+ gd + g_d_m[gm - 1];
			jy += 33 * ((int) (days / 12053));
			days %= 12053;
			jy += 4 * ((int) (days / 1461));
			days %= 1461;
			if (days > 365) {
				jy += (int) ((days - 1) / 365);
				days = (days - 1) % 365;
			}
			int jm = (days < 186) ? 1 + (int) (days / 31) : 7 + (int) ((days - 186) / 30);
			int jd = 1 + ((days < 186) ? (days % 31) : ((days - 186) % 30));
			int[] out = { jy, jm, jd };
			// return out;
			// return null;
			// return jy + "-" + jm + "-" + jd;

			String month1 = "";
			if (jm == 1)
				month1 = "فروردین";
			else if (jm == 2)
				month1 = "اردیبهشت";
			else if (jm == 3)
				month1 = "خرداد";
			else if (jm == 4)
				month1 = "تیر";
			else if (jm == 5)
				month1 = "مرداد";
			else if (jm == 6)
				month1 = "شهریور";
			else if (jm == 7)
				month1 = "مهر";
			else if (jm == 8)
				month1 = "آبان";
			else if (jm == 9)
				month1 = "آذر";
			else if (jm == 10)
				month1 = "دی";
			else if (jm == 11)
				month1 = "بهمن";
			else if (jm == 12)
				month1 = "اسفند";
			text2 = jd + " / " + jm + " / " + jy;
			return text2;
		}
		
		public static String findPersianDate(Date date) {
			try {
				String dateEng = date.toString();
				char[] mnth = new char[3];
				dateEng.getChars(4, 7, mnth, 0);
				String month = "";
				for (char c : mnth) {
					month += c;
				}
				System.err.println(month);
				int month1 = 0;
				if (month.equals("Jan"))
					month1 = 1;
				else if (month.equals("Feb"))
					month1 = 2;
				else if (month.equals("Mar"))
					month1 = 3;
				else if (month.equals("Apr"))
					month1 = 4;
				else if (month.equals("May"))
					month1 = 5;
				else if (month.equals("Jun"))
					month1 = 6;
				else if (month.equals("Jul"))
					month1 = 7;
				else if (month.equals("Aug"))
					month1 = 8;
				else if (month.equals("Sep"))
					month1 = 9;
				else if (month.equals("Oct"))
					month1 = 10;
				else if (month.equals("Nov"))
					month1 = 11;
				else if (month.equals("Dec"))
					month1 = 12;

				char[] dy = new char[2];
				dateEng.getChars(8, 10, dy, 0);
				String day = "";
				for (char c : dy) {
					day += c;
				}

				int day1 = Integer.parseInt(day);

				char[] yer = new char[4];
				dateEng.getChars(25, 29, yer, 0);
				String year = "";
				for (char c : yer) {
					year += c;
				}
				int year1 = Integer.parseInt(year);
				return gregorian_to_jalali(year1, month1, day1);
			} catch (Exception e) {
				return null;
			}
	
}
}
