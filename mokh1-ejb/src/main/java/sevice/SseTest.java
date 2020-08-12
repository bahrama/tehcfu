//package sevice;
//
//import java.util.Random;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.Singleton;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.sse.OutboundSseEvent;
//import javax.ws.rs.sse.Sse;
//import javax.ws.rs.sse.SseBroadcaster;
//import javax.ws.rs.sse.SseEventSink;
//
///**
// * Session Bean implementation class SseTest
// */
//@Singleton
//@Path("/sse/inventoryItems")
//@Produces("application/json")
//@Consumes("application/json")
//public class SseTest {
//
//    /**
//     * Default constructor. 
//     */
//	@Context
//	private Sse sse;
//	
//	private volatile static SseBroadcaster sseBroadcaster;
//	
//    public SseTest() {
//        // TODO Auto-generated constructor stub
//    }
//    @PostConstruct
//    public void postConst() {
//    	if(sseBroadcaster==null) {
//    		sseBroadcaster=sse.newBroadcaster();
//    	}
//    }
//    
//    @GET
//    @Path("/publish/{complaint}")
//    public void broadcast(@PathParam("complaint") String complaint) {
//    OutboundSseEvent event=sse.newEventBuilder()
//    		.data(String.class,complaint)
//    		.reconnectDelay(6)
//    		.build();
//    sseBroadcaster.broadcast(event);
//    }
//    
//    @GET
//    @Path("/subscribe")
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    public void register(@Context SseEventSink eventSink) {
//    	eventSink.send(sse.newEventBuilder().
//    			data(String.class,"ALIALIKHAH").reconnectDelay(500).build());
//    sseBroadcaster.register(eventSink);
//    }
//    
//    
//    
//    
//    
////    @GET
////	@Path("/command")
////	@Produces(MediaType.SERVER_SENT_EVENTS)
////    public void saluteSSE(@Context SseEventSink sseEventSink , @Context Sse sseUtil) {
////		try(SseEventSink sink=sseEventSink) {
////			for (int i = 0; i < 30; i++) {
////				try {
////					Thread.sleep(1000);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////				OutboundSseEvent event=sseUtil.newEvent(Integer.toString(new Random().nextInt(50)));
////				sseEventSink.send(event);
////			}
////		}
////	}
//    
//    
//
//}
