package Objects;

import ResourceAPIs.PlatformsApi;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.filip on 1/23/2018.
 */
public class PlatformObject extends PlatformsApi {


    String code;
    String name;


    PlatformObject platform;
    List<PlatformObject> platformObjectsCollection;
    JSONArray platformCollectionJson;


    public PlatformObject() throws IOException {
        platformCollectionJson=new JSONArray();
        platformObjectsCollection = new ArrayList<>();
        getPlatformApi();

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  //create a collection of PlatformObjects from the JsonArray
    private List<PlatformObject> getPlaformCollection() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray resp = super.getApiResponse();
        JsonFactory factory = new JsonFactory();
        JsonParser parser;
        for (int i = 0; i < resp.length(); i++) {
            JSONObject object = resp.getJSONObject(i);
            parser = factory.createParser(String.valueOf(object));
            platform = objectMapper.readValue(parser, PlatformObject.class);
            platformObjectsCollection.add(platform);
        }

        return platformObjectsCollection;

    }

    //map Api response to a JsonArray
    //Mongo needs a JsonObject for serialization
    public JSONArray getPlatformCollectionsAsJson(){

        platformCollectionJson=getApiResponse();

        return platformCollectionJson;

    }


    public static void main(String args[]) throws IOException {

        PlatformObject p=new PlatformObject();
       System.out.print( p.getPlatformCollectionsAsJson());
    }


}
