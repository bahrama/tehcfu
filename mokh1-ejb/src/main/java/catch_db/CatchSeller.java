package catch_db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entity.MoblEntity;
import entity.RentEntity;
import sevice.SellerServiceLocal;

/**
 * Session Bean implementation class CatchSeller
 */
@Startup
@Singleton
public class CatchSeller implements CatchSellerLocal {

	/**
	 * Default constructor.
	 */
	public CatchSeller() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private SellerServiceLocal sellerServiceLocal;

	private List<MoblEntity> sellerList = new ArrayList<>();
	
	private Set<MoblEntity> onlineUsers=new HashSet<>();

	private Set<MoblEntity> vitrinMoblKhanegi = new HashSet<>();
	private Set<MoblEntity> vitrinMoblEdari = new HashSet<>();
	private Set<MoblEntity> vitrinMoblSismoni = new HashSet<>();
	private Set<MoblEntity> vitrinMoblKabinet = new HashSet<>();
	private Set<MoblEntity> vitrinMoblMasnoat = new HashSet<>();
	private Set<MoblEntity> vitrinMoblTamirat = new HashSet<>();
	private Set<MoblEntity> vitrinMoblDecor = new HashSet<>();
	private Set<MoblEntity> vitrinMoblMotefarege = new HashSet<>();
	private List<MoblEntity> AdiList=new ArrayList<>();

	private Map<MoblEntity, String> bind = new HashMap<>();

	@Override
	public List<MoblEntity> getSellerList() {
		return sellerList;
	}

	
	@Override
	public Set<MoblEntity> getVitrinMoblKhanegi() {
		return vitrinMoblKhanegi;
	}


	@Override
	public Set<MoblEntity> getVitrinMoblEdari() {
		return vitrinMoblEdari;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblSismoni() {
		return vitrinMoblSismoni;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblKabinet() {
		return vitrinMoblKabinet;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblMasnoat() {
		return vitrinMoblMasnoat;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblTamirat() {
		return vitrinMoblTamirat;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblDecor() {
		return vitrinMoblDecor;
	}

	@Override
	public Set<MoblEntity> getVitrinMoblMotefarege() {
		return vitrinMoblMotefarege;
	}

    @Override
	public Set<MoblEntity> getOnlineUsers() {
		return onlineUsers;
	}

    @Override
	public List<MoblEntity> getAdiList() {
		return AdiList;
	}


	public void bindVitrin() {
		this.vitrinMoblDecor.clear();
		this.vitrinMoblEdari.clear();
		this.vitrinMoblKabinet.clear();
		this.vitrinMoblKhanegi.clear();
		this.vitrinMoblMasnoat.clear();
		this.vitrinMoblMotefarege.clear();
		this.vitrinMoblMotefarege.clear();
		this.vitrinMoblSismoni.clear();
		this.vitrinMoblTamirat.clear();
		String[] strings = {};
		for (MoblEntity moblEntity : sellerServiceLocal.findAllSeller()) {
			try {
				if(moblEntity.getPanel().equals("A")||moblEntity.getPanel().equals("B")||moblEntity.getPanel().equals("C")) {
				strings = moblEntity.getFaaliat().split("-");
				for (String string : strings) {
					System.err.println(string);
					 this.bind.put(moblEntity, string);
					if (string.equals("مبلمان راحتی") || string.equals("مبلمان کلاسیک") || string.equals("مبلمان استیل")
							|| string.equals("مبلمان فضای باز") || string.equals("مبل تختخواب شو")
							) {
						this.vitrinMoblKhanegi.add(moblEntity);
					}
					else if (string.equals("میز اداری") || string.equals("صندلی اداری")) {
						this.vitrinMoblEdari.add(moblEntity);
					}
					else if (string.equals("سیسمونی")) {
						this.vitrinMoblSismoni.add(moblEntity);
					}
					else if (string.equals("کابینت")) {
						this.vitrinMoblKabinet.add(moblEntity);
					}
					else if (string.equals("نهار خوری") || string.equals("سرویس خواب") || string.equals("میز تلویزیون")
							|| string.equals("آینه و کنسول") || string.equals("قاب عکس")|| string.equals("میز جلو مبلی یا میز عسلی")
							) {
						this.vitrinMoblMasnoat.add(moblEntity);
					}
					else if (string.equals("تعمیرات")) {
						this.vitrinMoblTamirat.add(moblEntity);
					}
					else if (string.equals("دکوراسیون تخصصی") || string.equals("دکوراسیون تخصصی")) {
						this.vitrinMoblDecor.add(moblEntity);
					}
					else {
						this.vitrinMoblMotefarege.add(moblEntity);
					}
				}
				}
			} catch (Exception e) {
				System.err.println("nullllll");
			}
			System.err.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		}
		
	}

	@PostConstruct
	public void init() {
		this.sellerList.addAll(sellerServiceLocal.findAllSeller());
		bindVitrin();
		
	}

	@Schedule(hour = "*", minute = "*/5", persistent = false)
	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
	public void ejra() {
		this.sellerList.clear();
		this.sellerList.addAll(sellerServiceLocal.findAllSeller());
		bindVitrin();
	}
	
	


}
