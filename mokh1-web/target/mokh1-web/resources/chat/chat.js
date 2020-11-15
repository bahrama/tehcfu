$(document)
		.ready(
				
				function() {
					const utl = "http://192.168.10.77:8080/rest/api/sellers/all";
					fetch(utl)
							.then(function(res) {
								return res.json()
							})
							.then(
									function(data) {
										data
												.forEach(function(friend) {
													//alert(friend.sellerStorePer);
													$("#chusr").append("<a href='javascript:void(0)'><div class='chat-data'><div class='user-data'><span class='name block capitalize-font'>Clay Masse</span> <span class='time block truncate txt-grey'>No one saves us but ourselves.</span></div><div class='status away'></div><div class='clearfix'></div></div></a>");
												})
									})
									
				});

