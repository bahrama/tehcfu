package admin;

public enum HomeCategories {
	A("اتحادیه صنف درودگران و مبلسازان تهران")
	,B("لوگو"),
	C("اسلاید"),
	D("نزدیکترین ها"),
	E("اعضای صنفی اتحادیه"),
	F("نیازمندی ها"),
	G("تبلیغ"),
	H("طرح های خلاقانه"),
	I("خبرنامه نمایشگاهی"),
	J("دانستنی ها");
	private String homeName;

	private HomeCategories(String homeName) {
		this.homeName = homeName;
	}

	public String getHomeCategories() {
		return homeName;
	}
}
