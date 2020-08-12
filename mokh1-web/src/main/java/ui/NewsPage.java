package ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;

import catch_db.CatchBlogLocal;
import entity.BlogEntity;
import entity.HomeEntity;

@Named
@ViewScoped
public class NewsPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewsPage() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private CatchBlogLocal catchBlogLocal;

	private List<BlogEntity> blogEntities=new ArrayList<>();
	private List<BlogEntity> blogEntitiesSH=new ArrayList<>();
	private List<BlogEntity> blogEntitiesML=new ArrayList<>();
	private List<BlogEntity> blogEntitiesGM=new ArrayList<>();
	
	
    public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}


	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
	}
	
	
	


	public List<BlogEntity> getBlogEntitiesSH() {
		return blogEntitiesSH;
	}


	public void setBlogEntitiesSH(List<BlogEntity> blogEntitiesSH) {
		this.blogEntitiesSH = blogEntitiesSH;
	}


	public List<BlogEntity> getBlogEntitiesML() {
		return blogEntitiesML;
	}


	public void setBlogEntitiesML(List<BlogEntity> blogEntitiesML) {
		this.blogEntitiesML = blogEntitiesML;
	}


	public List<BlogEntity> getBlogEntitiesGM() {
		return blogEntitiesGM;
	}


	public void setBlogEntitiesGM(List<BlogEntity> blogEntitiesGM) {
		this.blogEntitiesGM = blogEntitiesGM;
	}


	@PostConstruct
	public void start() {
    	for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
		if(blogEntity.getBlogType().equals("خبر"))
			blogEntities.add(blogEntity);
	}
    	for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
		if(blogEntity.getBlogType().equals("مناسبت شمسی"))
			blogEntitiesSH.add(blogEntity);
	}
    	
    	for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
		if(blogEntity.getBlogType().equals("مناسبت قمری"))
			blogEntitiesGM.add(blogEntity);
	}
    	
    	for (BlogEntity blogEntity : catchBlogLocal.getBlogEntities()) {
		if(blogEntity.getBlogType().equals("مناسبت میلادی"))
			blogEntitiesML.add(blogEntity);
	}
    
	Collections.reverse(blogEntities);
	Collections.reverse(blogEntitiesGM);
	Collections.reverse(blogEntitiesML);
	Collections.reverse(blogEntitiesSH);
	}
	
	
	public byte[] findBlogPicById(int id) {
		BlogEntity blogEntity=new BlogEntity();
		for (BlogEntity blogEntity2 : this.blogEntities) {
			if(blogEntity2.getId()==id)
			blogEntity=blogEntity2;
		}
		return this.findPic1(blogEntity);
		
	}
	
	public byte[] findPic1(BlogEntity blogEntity) {
		try {
		File imageFile1=new File("/home/wildfly/AX/" + blogEntity.getPic1().toString() + ".jpg");
		BufferedImage image1=ImageIO.read(imageFile1);
		ByteArrayOutputStream baos1=new ByteArrayOutputStream();
		ImageIO.write(image1, "jpg", baos1);
		return baos1.toByteArray();
		}catch (Exception e) {
			return null;
		}
	}
	
	public int size() {
		if(this.blogEntities.size()>4)
			return 4;
		else 
		    return blogEntities.size();	
		
	}
	
	public int size2() {
		if(this.blogEntities.size()>30)
			return 30;
		else 
		    return blogEntities.size();	
		
	}
	
	
	
	
///////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	public String findDate() {
		LocalDate localDate=new LocalDate();
		String month1 = "";
		if (localDate.getMonthOfYear()==1)
			month1 = "Jan";
		else if (localDate.getMonthOfYear()==2)
			month1 = "Feb";
		else if (localDate.getMonthOfYear()==3)
			month1 = "Mar";
		else if (localDate.getMonthOfYear()==4)
			month1 = "Apr";
		else if (localDate.getMonthOfYear()==5)
			month1 = "May";
		else if (localDate.getMonthOfYear()==6)
			month1 = "Jun";
		else if (localDate.getMonthOfYear()==7)
			month1 = "Jul";
		else if (localDate.getMonthOfYear()==8)
			month1 = "Aug";
		else if (localDate.getMonthOfYear()==9)
			month1 = "Sep";
		else if (localDate.getMonthOfYear()==10)
			month1 = "Oct";
		else if (localDate.getMonthOfYear()==11)
			month1 = "Nov";
		else if (localDate.getMonthOfYear()==12)
			month1 = "Dec";
		String text=" روز " + localDate.getDayOfMonth() +  " ماه " + month1 + " سال " + localDate.getYear() + " میلادی ";
		return text;
	}
	
	public String gregorian_to_jalali(int gy, int gm, int gd) {
		String text2="";
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
		//return jy + "-" + jm + "-" + jd;
		
		String month1 = "";
		if (jm==1)
			month1 = "فروردین";
		else if (jm==2)
			month1 = "اردیبهشت";
		else if (jm==3)
			month1 = "خرداد";
		else if (jm==4)
			month1 = "تیر";
		else if (jm==5)
			month1 = "مرداد";
		else if (jm==6)
			month1 = "شهریور";
		else if (jm==7)
			month1 = "مهر";
		else if (jm==8)
			month1 = "آبان";
		else if (jm==9)
			month1 = "آذر";
		else if (jm==10)
			month1 = "دی";
		else if (jm==11)
			month1 = "بهمن";
		else if (jm==12)
			month1 = "اسفند";
	     text2 = " روز " + jd +  " ماه " + month1 + " سال " + jy + " شمسی ";
		return text2;
	}
	
	
	public String convertToJalali() {
		try {
		String dateEng = new Date().toString();
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
		}catch (Exception e) {
			return null;
		}
		
		

	}
	
	public String hejriDate() {
		LocalDate localDate=new LocalDate();
        String month="";
        String text="";
		Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();

        LocalDate todayIso = new LocalDate(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth(), iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
                                             hijri);
        
        if(todayHijri.getMonthOfYear()==1)
        	month="محرم";
        else if (todayHijri.getMonthOfYear()==2)
        	month="صفر";
        else if (todayHijri.getMonthOfYear()==3)
        	month="ربیع‌الاول";
        else if (todayHijri.getMonthOfYear()==4)
        	month="ربیع‌الثانی";
        else if (todayHijri.getMonthOfYear()==5)
        	month="جمادی‌الاول";
        else if (todayHijri.getMonthOfYear()==6)
        	month="جمادی‌الثانی";
        else if (todayHijri.getMonthOfYear()==7)
        	month="رجب";
        else if (todayHijri.getMonthOfYear()==8)
        	month="شعبان";
        else if (todayHijri.getMonthOfYear()==9)
        	month="رمضان";
        else if (todayHijri.getMonthOfYear()==10)
        	month="شوال";
        else if (todayHijri.getMonthOfYear()==11)
        	month="ذیقعده";
        else if (todayHijri.getMonthOfYear()==12)
        	month="ذیحجه";
        text=" روز " + (todayHijri.getDayOfMonth()) + " ماه " + month + " سال " + todayHijri.getYear() + "قمری";
        
        return text;
	}
	
	public BlogEntity findMonasebatShamsi() {
		BlogEntity blogEntity2=new BlogEntity();
		LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesSH) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
               
		}
		
		return blogEntity2;
	}
	
	public BlogEntity findMonasebatMiladi() {
		BlogEntity blogEntity2=new BlogEntity();
		LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesML) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
	
	public BlogEntity findMonasebatGamari() {
		BlogEntity blogEntity2=new BlogEntity();
		LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesGM) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
	
	public BlogEntity findMonasebatShamsiByDate(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesSH) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
               
		}
		
		return blogEntity2;
	}
	
	public BlogEntity findMonasebatMiladiByDate(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesML) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
	
	public BlogEntity findMonasebatGamariByDate(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesGM) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public List<BlogEntity> findAllBlogMonasebat(){
//		return singletonServiceLocal.getAllBlogMonasebat();
//	}
	

	public List<LocalDate> findCurrentDate(){
		LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int month=localDate.getMonthOfYear();
		int day=localDate.getDayOfMonth();
		List<LocalDate> dates=new ArrayList<>();
		System.err.println(LocalDate.now());
		LocalDate localDate2=new LocalDate("2019-08-05");
		System.err.println(localDate2.getDayOfMonth());
		if(month==1)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==2)
		for (int i=1 ; i <= 29 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==3)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==4)
		for (int i=1 ; i <= 30 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==5)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==6)
		for (int i=1 ; i <= 30 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==7)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==8)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==9)
		for (int i=1 ; i <= 30 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==10)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==11)
		for (int i=1 ; i <= 30 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		if(month==12)
		for (int i=1 ; i <= 31 ; i++) {
			dates.add(new LocalDate(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(i)));
		}
		for (LocalDate localDate3 : dates) {
			System.err.println(localDate3);
		}
		return dates;
	}
	
	public String gregorian_to_jalali2(int gy, int gm, int gd) {
		String text2="";
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
		//return jy + "-" + jm + "-" + jd;
		
		String month1 = "";
		if (jm==1)
			month1 = "فروردین";
		else if (jm==2)
			month1 = "اردیبهشت";
		else if (jm==3)
			month1 = "خرداد";
		else if (jm==4)
			month1 = "تیر";
		else if (jm==5)
			month1 = "مرداد";
		else if (jm==6)
			month1 = "شهریور";
		else if (jm==7)
			month1 = "مهر";
		else if (jm==8)
			month1 = "آبان";
		else if (jm==9)
			month1 = "آذر";
		else if (jm==10)
			month1 = "دی";
		else if (jm==11)
			month1 = "بهمن";
		else if (jm==12)
			month1 = "اسفند";
	     text2 = "" +  jd + "" + month1;
		return text2;
	}
	
	public String findShamsi(LocalDate localDate) {
       // List<String> allShamsi=new ArrayList<>();
       // for (LocalDate localDate : this.findCurrentDate()) {
			return this.gregorian_to_jalali2(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
		//}
        //return allShamsi;
	}
	
	
	public String hejriDate2(LocalDate localDate) {
        String month="";
        String text="";
		Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();

        LocalDate todayIso = new LocalDate(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth(), iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
                                             hijri);
        
        if(todayHijri.getMonthOfYear()==1)
        	month="محرم";
        else if (todayHijri.getMonthOfYear()==2)
        	month="صفر";
        else if (todayHijri.getMonthOfYear()==3)
        	month="ربیع‌الاول";
        else if (todayHijri.getMonthOfYear()==4)
        	month="ربیع‌الثانی";
        else if (todayHijri.getMonthOfYear()==5)
        	month="جمادی‌الاول";
        else if (todayHijri.getMonthOfYear()==6)
        	month="جمادی‌الثانی";
        else if (todayHijri.getMonthOfYear()==7)
        	month="رجب";
        else if (todayHijri.getMonthOfYear()==8)
        	month="شعبان";
        else if (todayHijri.getMonthOfYear()==9)
        	month="رمضان";
        else if (todayHijri.getMonthOfYear()==10)
        	month="شوال";
        else if (todayHijri.getMonthOfYear()==11)
        	month="ذیقعده";
        else if (todayHijri.getMonthOfYear()==12)
        	month="ذیحجه";
       // text=todayHijri.getDayOfMonth()  + "" + month;
        int s = todayHijri.getDayOfMonth()-1;
        if(s==31)
        	s=1;
        else 
        	s=todayHijri.getDayOfMonth();
        text= "" +  s + "" +month;
        return text;
	}
	
/*	public String findGamari(LocalDate localDate) {
	       // List<String> allShamsi=new ArrayList<>();
	       // for (LocalDate localDate : this.findCurrentDate()) {
				return this.gregorian_to_jalali2(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
			//}
	        //return allShamsi;
		}*/
	
	
	
	public String findCurrentMiladi(LocalDate localDate){
		int year=localDate.getYear();
		int month=localDate.getMonthOfYear();
		int day=localDate.getDayOfMonth();
		if(month==1)
            return "" + String.valueOf(day) + "" + "ژانویه";
		else if(month==2)
			return "" + String.valueOf(day) + "" + "فوریه";		
		else if(month==3)
			return "" + String.valueOf(day) + "" + "مارس";		
		else if(month==4)
			return "" + String.valueOf(day) + "" + "آوریل";		
		else if(month==5)
			return "" + String.valueOf(day) + "" + "می";		
		else if(month==6)
			return "" + String.valueOf(day) + "" + "جون";		
		else if(month==7)
			return "" + String.valueOf(day) + "" + "جولای";		
		else if(month==8)
			return "" + String.valueOf(day) + "" + "آگوست";		
		else if(month==9)
			return "" + String.valueOf(day) + "" + "سپتامبر";		
		else if(month==10)
			return "" + String.valueOf(day) + "" + "اکتبر";		
		else if(month==11)
			return "" + String.valueOf(day) + "" + "نوامر";		
		else if(month==12)
			return "" + String.valueOf(day) + "" + "دسامبر";		
		else
			return null;
	}
	
	
	public BlogEntity findMonasebatShamsi2(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.getBlogEntitiesSH()) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
               
		}
		
		return blogEntity2;
	}
	
	public BlogEntity findMonasebatMiladi2(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		//LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesML) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
	
	public BlogEntity findMonasebatGamari2(LocalDate localDate) {
		BlogEntity blogEntity2=new BlogEntity();
		//LocalDate localDate=new LocalDate();
		int year=localDate.getYear();
		int day=localDate.getDayOfYear();

		for (BlogEntity blogEntity : this.blogEntitiesGM) {
               LocalDate localDate2=new LocalDate(blogEntity.getBlogDate());
               if(localDate2.getYear()==year)
            	   if(localDate2.getDayOfYear()==day)
            		   blogEntity2=blogEntity;
		}
		return blogEntity2;
	}
	
//	public List<BlogEntity> findAllTodayNews(){
//		List<BlogEntity> blogEntity2=new ArrayList<>();
//		LocalDate localDate=new LocalDate();
//		int year=localDate.getYear();
//		int day=localDate.getDayOfYear();
//		
//		System.err.println(localDate);
//		for (BlogEntity blogEntity : singletonServiceLocal.getNewsBlogList()) {
//            LocalDate localDate2=new LocalDate(blogEntity.getDate());
//           // if(localDate2.getYear()==year)
//         	 //  if(localDate2.getDayOfYear()==day)
//            System.err.println(localDate2);
//            System.err.println(blogEntity.getDate());
//            if(!(localDate2.equals(null)))
//            {
//            if(localDate2.equals(localDate)) {
//         		   blogEntity2.add(blogEntity);
//         		   
//         		   System.err.println(localDate2);
//            }
//            }
//            
//		}
//		return blogEntity2;
//	}
	
	
	
	


}
