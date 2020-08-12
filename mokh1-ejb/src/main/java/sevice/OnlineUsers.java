package sevice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entity.MoblEntity;

/**
 * Session Bean implementation class OnlineUsers
 */
@Singleton
@Startup
public class OnlineUsers implements OnlineUsersLocal {

    /**
     * Default constructor. 
     */
    public OnlineUsers() {
        // TODO Auto-generated constructor stub
    }
    
    private Set<MoblEntity> mobls=new HashSet<>();

    @Override
	public Set<MoblEntity> getMobls() {
 //   	try {
//    	URL url=new URL("http://192.168.1.77:8080/hsport/api/sse/inventoryItems/publish/ok");
//    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//    	conn.setDoOutput(true);
//    	conn.setRequestMethod("GET");
//    	conn.setRequestProperty("Content-Type", "application/json");
//    	conn.setRequestProperty("Accept", "application/json");
//			int responseCode = conn.getResponseCode();
//			System.err.println("sended ok code :" + responseCode);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return mobls;
	}

    
	
}
