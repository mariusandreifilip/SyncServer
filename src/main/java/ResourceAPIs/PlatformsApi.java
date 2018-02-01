package ResourceAPIs;

import Api.HttpClient;
import net.sf.json.JSONArray;

import static Constants.ApiConstants.PlatformApiUrl;

/**
 * Created by andrei.filip on 1/22/2018.
 */

//  GET https://crash-stats.mozilla.com/api/Platforms/

public class PlatformsApi {

    private  Api.HttpClient api;
     JSONArray ApiResponse;


    public PlatformsApi(){

        this.ApiResponse=new JSONArray();

    }

    protected void getPlatformApi(){
         api=new HttpClient();
         api.generateUrl("GET",PlatformApiUrl,null,false);
         setApiResponse();

    }

    private  void setApiResponse(){
        this.ApiResponse=JSONArray.fromObject(api.getResponseJson());

    }

    public JSONArray getApiResponse(){
        return ApiResponse;


    }



}




