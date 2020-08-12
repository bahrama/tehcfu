document.getElementById("myCheckf").checked = true;
var mymap;
var lyrOSM;
var mrkly ;
var mrrlys=[];
$(document).ready(
		function() {
			mymap = L.map('mapdiv', {
				center : [ 35.68351, 51.40795 ],
				zoom : 11
			});
			lyrOSM = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png');
			mymap.addLayer(lyrOSM);
			const utl = "https://www.tehcfu.com/rest/api/sellers/all";
			fetch(utl).then(function(res) {
				return res.json()
			}).then(
					function(data) {
						console.log(data);
						// alert(data);
						data.forEach(function(friend) {
							// L.marker(friend.lat,friend.lng).addTo(mymap);
							// console.log(friend.lat);
							// console.log(friend.lng);
							mrkly =	L.marker([ friend.lat, friend.lng ]).addTo(mymap)
									.bindPopup(
											"<a href=https://www.tehcfu.com/sellers/"
													+ friend.sellerStoreEng
													+ ">"
													+ friend.sellerStorePer
													+ "</a>");
							mrrlys.push(mrkly);
						})
					})
			
					$('#myForm input').on('change', function() {	
						for (var i = 0; i < mrrlys.length; i++) {
							try{
							mymap.removeLayer(mrrlys[i]);
							}catch (ess) {
								// TODO: handle exception
							}
							}
						
						var sel=$('input[name=color]:checked', '#myForm').val();
						   //	alert(sel);	
						    fetch(utl).then(function(res) {
								return res.json()
							}).then(
									function(data) {
										console.log(data);
										// alert(data);
										data.forEach(function(friend) {
											// L.marker(friend.lat,friend.lng).addTo(mymap);
											// console.log(friend.lat);
											// console.log(friend.lng);
											var rest=friend.faaliat;
											//var n = rest.search("سیسمونی");
											//alert(rest);
											  //var str = "Visit W3Schools!";
											try{
											  //مبل خانگی
											  var a=rest.search("مبلمان راحتی");
											  var b=rest.search("مبلمان کلاسیک");
											  var c=rest.search("مبلمان استیل");
											  var d=rest.search("مبلمان فضای باز");
											  var e=rest.search("مبل تختخواب شو");
											  var aa=parseInt(a);
											  var bb=parseInt(b);
											  var cc=parseInt(c);
											  var dd=parseInt(d);
											  var ee=parseInt(e);
											   if((aa>-1||bb>-1||cc>-1||dd>-1||ee>-1) && sel=="مبلمان خانگی")
											   {
												 //  alert('ok');
												    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
													.bindPopup(
															"<a href=https://www.tehcfu.com/sellers/"
																	+ friend.sellerStoreEng
																	+ ">"
																	+ friend.sellerStorePer
																	+ "</a>");
												    mrrlys.push(mrkly);
											   }
											   //مبلمان اداری
												  var aaa=rest.search("میز اداری");
												  var bbb=rest.search("صندلی اداری");
												  var aaaa=parseInt(aaa);
												  var bbbb=parseInt(bbb);
	
												   if((aaaa>-1||bbbb>-1) && sel=="مبلمان اداری")
												   {
													 //  alert('ok');
													    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
														.bindPopup(
																"<a href=https://www.tehcfu.com/sellers/"
																		+ friend.sellerStoreEng
																		+ ">"
																		+ friend.sellerStorePer
																		+ "</a>");
													    mrrlys.push(mrkly);
												   }
											   
											   //سیسمونی
											  var n = rest.search("سیسمونی");
											  var x=parseInt(n);
											   if(x>-1 && sel=="سیسمونی")
											   {
												 //  alert('ok');
												    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
													.bindPopup(
															"<a href=https://www.tehcfu.com/sellers/"
																	+ friend.sellerStoreEng
																	+ ">"
																	+ friend.sellerStorePer
																	+ "</a>");
												    mrrlys.push(mrkly);
											   }
											   //کابینت آشپزخانه
												  var aaaaa=rest.search("کابینت");
												  var aaaaaa=parseInt(aaaaa);
	
												   if((aaaaaa>-1) && sel=="کابینت آشپزخانه")
												   {
													 //  alert('ok');
													    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
														.bindPopup(
																"<a href=https://www.tehcfu.com/sellers/"
																		+ friend.sellerStoreEng
																		+ ">"
																		+ friend.sellerStorePer
																		+ "</a>");
													    mrrlys.push(mrkly);
												   }
											   //مصنوعات چوبی
												      var ax=rest.search("نهار خوری");
													  var bx=rest.search("سرویس خواب");
													  var cx=rest.search("میز تلویزیون");
													  var dx=rest.search("آینه و کنسول");
													  var ex=rest.search("قاب عکس");
													  var exx=rest.search("قاب عکس");
													  var aax=parseInt(ax);
													  var bbx=parseInt(bx);
													  var ccx=parseInt(cx);
													  var ddx=parseInt(dx);
													  var eex=parseInt(ex);
													  var eexx=parseInt(exx);
													   if((aax>-1||bbx>-1||ccx>-1||ddx>-1||eex>-1||eexx>-1) && sel=="مصنوعات چوبی")
													   {
														 //  alert('ok');
														    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
															.bindPopup(
																	"<a href=https://www.tehcfu.com/sellers/"
																			+ friend.sellerStoreEng
																			+ ">"
																			+ friend.sellerStorePer
																			+ "</a>");
														    mrrlys.push(mrkly);
													   }
													   //تعمیرات
														  var aw=rest.search("تعمیرات");
														  var aaw=parseInt(aw);
			
														   if((aaw>-1) && sel=="تعمیرات")
														   {
															 //  alert('ok');
															    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
																.bindPopup(
																		"<a href=https://www.tehcfu.com/sellers/"
																				+ friend.sellerStoreEng
																				+ ">"
																				+ friend.sellerStorePer
																				+ "</a>");
															    mrrlys.push(mrkly);
														   }
														   //دکوراسیون
															  var aw2=rest.search("دکوراسیون تخصصی");
															  var aaw2=parseInt(aw2);
															  var aww=rest.search("دکوراسیون تخصصی");
															  var aaww=parseInt(aww);
				
															   if((aaw2>-1||aww>-1) && sel=="دکوراسیون")
															   {
																 //  alert('ok');
																    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
																	.bindPopup(
																			"<a href=https://www.tehcfu.com/sellers/"
																					+ friend.sellerStoreEng
																					+ ">"
																					+ friend.sellerStorePer
																					+ "</a>");
																    mrrlys.push(mrkly);
															   }
															   //
															   if(sel=="همه رسته ها")
															   {
																 //  alert('ok');
																    mrkly = L.marker([ friend.lat, friend.lng ]).addTo(mymap)
																	.bindPopup(
																			"<a href=https://www.tehcfu.com/sellers/"
																					+ friend.sellerStoreEng
																					+ ">"
																					+ friend.sellerStorePer
																					+ "</a>");
																    mrrlys.push(mrkly);
															   }
															   
															   
											}catch(err){
												
											}
											  //alert(n);

										})
									})
							   
									
					});				
					
		});

