package ResourceAPIs;

import Api.HttpClient;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.sf.json.JSONObject;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrei.filip on 1/22/2018.
 */

//TOP CRASH BY CONFIG LOOKUP

//https://crash-stats.mozilla.com/api/SuperSearch/?
// signature=~gfx&
// signature=~layers&
// signature=~glcontext&
// signature=~canvas&
// signature=~d3d&
// signature=~d2d&
// signature=~dwrite&
// signature=~skia&
// signature=~mesa&
// signature=~cairo&
// signature=^amd&
// signature=^ati&
// signature=^igd&
// signature=^nv&
// signature=~webgl&
// date=>=2017-07-27&
// date=<=2018-01-24&
// _histogram.date=signature&
// _histogram_interval=1d

public class FirefoxCrashes extends HttpClient{
    private static final String URL="https://crash-stats.mozilla.com/api/SuperSearch/";
    private static List<String> SignatureParams= Arrays.asList("~gfx","~layers","~glcontext","~canvas","~d3d","~d2d","~dwrite","~skia","~mesa","~cairo","^amd","^ati","^igd","^nv","~webgl");


    MultivaluedMap<String,String> Query_params;

    JSONObject apiResponse;



    FirefoxCrashes(){
        Query_params=new MultivaluedMapImpl();
        apiResponse=new JSONObject();
        createQueryMap();
        createApiRequest();

    }




    private void createQueryMap(){
        Query_params.put("signature",SignatureParams);
        Query_params.putSingle("date",">=2017-01-27");
        Query_params.putSingle("_histogram.date","signature");
        Query_params.putSingle("_histogram_interval","1d");

    }


    private void createApiRequest() {
        try {
            generateUrl("GET", URL, Query_params,false);

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public JSONObject getApiResponse(){
        apiResponse=JSONObject.fromObject(getResponseJson());
        return  apiResponse;

    }



    public static void main(String args[]){

   FirefoxCrashes c=new FirefoxCrashes();
   System.out.print(c.getApiResponse());




    }




}
