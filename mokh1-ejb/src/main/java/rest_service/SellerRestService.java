package rest_service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;


import dao.SellerTblDaoLocal;
import entity.MoblEntity;

/**
 * Session Bean implementation class SellerRestService
 */
@Stateless
@Path("/sellers")
public class SellerRestService{

    /**
     * Default constructor. 
     */
    public SellerRestService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private SellerTblDaoLocal sellerTblDaoLocal;

   
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findSellerById(@PathParam("id") final long id) {
    	System.err.println("RRRRRRRRRRRRRREEEEEEEEEEEEESSSSSSSSTTTTTTTTTT");
    	MoblEntity moblEntity=new MoblEntity();
    	try {
			moblEntity= sellerTblDaoLocal.findSellerById(id);
			System.err.println(moblEntity.getMobile());

			//String json="{\"name\":\"mkyong\",\"age\":35,\"position\":[\"Founder\",\"CTO\",\"Writer\"],\"skills\":[\"java\",\"python\",\"node\",\"kotlin\"],\"salary\":{\"2018\":14000,\"2012\":12000,\"2010\":10000}}";
			//System.err.println(json);
			Jsonb jsonb=JsonbBuilder.create();
			String json=jsonb.toJson("ali");
			
			if(moblEntity!=null)
			return Response.ok(moblEntity).build();
			else
			return Response.status(Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllSeller() {
    	System.err.println("RRRRRRRRRRRRRREEEEEEEEEEEEESSSSSSSSTTTTTTTTTT");
    	MoblEntity moblEntity=new MoblEntity();
    	List<MoblEntity> allSeller=new ArrayList<MoblEntity>();

    	try {
    		allSeller.addAll(sellerTblDaoLocal.findAllMapSeller());
			//System.err.println(moblEntity.getMobile());

			//String json="{\"name\":\"mkyong\",\"age\":35,\"position\":[\"Founder\",\"CTO\",\"Writer\"],\"skills\":[\"java\",\"python\",\"node\",\"kotlin\"],\"salary\":{\"2018\":14000,\"2012\":12000,\"2010\":10000}}";
			//System.err.println(json);
			Jsonb jsonb=JsonbBuilder.create();
			String json=jsonb.toJson(allSeller);
			
			if(moblEntity!=null)
			return Response.ok(sellerTblDaoLocal.findAllSeller()).build();
			else
			return Response.status(Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @GET
    @Path("/findname/{sellerName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findSellerBySellerNAmeLike(@PathParam("sellerName") final String sellerName) {
    	System.err.println("RRRRRRRRRRRRRREEEEEEEEEEEEESSSSSSSSTTTTTTTTTT");
    	List<MoblEntity> moblEntities=new ArrayList<>();
    	try {
			moblEntities= sellerTblDaoLocal.findSellersByLikeName(sellerName);
			//String json="{\"name\":\"mkyong\",\"age\":35,\"position\":[\"Founder\",\"CTO\",\"Writer\"],\"skills\":[\"java\",\"python\",\"node\",\"kotlin\"],\"salary\":{\"2018\":14000,\"2012\":12000,\"2010\":10000}}";
			//System.err.println(json);
			Jsonb jsonb=JsonbBuilder.create();
			String json=jsonb.toJson(moblEntities);
			
			if(moblEntities!=null)
			return Response.ok(moblEntities).build();
			else
			return Response.status(Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }

}
