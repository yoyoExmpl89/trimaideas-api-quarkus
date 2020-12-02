package id.trimegah.newsfeed.resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import id.trimegah.newsfeed.models.NewsFeedNotif;
import id.trimegah.newsfeed.models.NewsFeedNotifDetail;
import id.trimegah.newsfeed.services.NewsFeedNotifDetailService;
import id.trimegah.newsfeed.services.NewsFeedNotifService;
import id.trimegah.response.ResourceNotifResponse;
import id.trimegah.response.ResourceNotifResponseDetail;
import id.trimegah.response.ResourceResponse;
import org.apache.commons.codec.binary.Base64;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Path("/newsFeeds/notif")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewsFeedNotifResource {

    @Inject
    NewsFeedNotifDetailService newsFeedNotifDetailService;

    @Inject
    NewsFeedNotifService newsFeedNotifService;



    //-- post create inbox
    @POST
    @Transactional
    public ResourceNotifResponse postInboxDetail(@Context HttpHeaders headers,NewsFeedNotifDetail newsFeedNotifDetail){

            try{
                NewsFeedNotifDetail temp = newsFeedNotifDetailService.create(newsFeedNotifDetail);
                return ResourceNotifResponse.dataDetail(temp);
                //return ResourceNotifResponse.data(newsFeedNotifDetailService.create(newsFeedNotifDetail));
            }catch(Exception e){
                System.out.println("error " + newsFeedNotifDetail.getSubtitle());
                return ResourceNotifResponse.error(newsFeedNotifDetail,e.getMessage());
            }


    }

    @GET
    @Path("/getNotif/{page}/{size}")
    public ResourceNotifResponse getNotif(@Context HttpHeaders headers,@PathParam("page") int page, @PathParam("size") int size) throws MalformedURLException {
        /*String s = headers.getRequestHeaders().getFirst("authorization");
        String base64Credentials = s.substring("Basic".length()).trim();
        byte[] decodedBytes = Base64.decodeBase64(base64Credentials.getBytes());
        String pair = new String(decodedBytes);
        String[] userDetails = pair.split(":", 2);
*/

        try{
            //NewsFeedNotifService temp = (NewsFeedNotifService) newsFeedNotifService.getPageList(page,size);
            return ResourceNotifResponse.datapaging(newsFeedNotifService.getPageList(page,size),newsFeedNotifService.getTotal());
        }catch(Exception e){
            return ResourceNotifResponse.errordata(e.getMessage());
        }



    }

    public boolean getBooleanLogin(String username, String password){
        boolean checker = false;
        try {
            String joining = username + ":" + password;
            byte[] encoding = Base64.encodeBase64(joining.getBytes());
            String authStringEnc = new String(encoding);
            String result = "";

            URL url = new URL("http://172.16.1.53:4444/newsfeed?x=");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            result = sb.toString();
            //System.out.println(result);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonTree = jsonParser.parse(result);
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            if(jsonObject.get("status").toString() == "1"){
                checker = true;
            }

        }catch(IOException e){
           checker = false;
        }
        return checker;
    }




}
