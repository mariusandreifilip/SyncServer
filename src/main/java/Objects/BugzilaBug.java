package Objects;

import ResourceAPIs.BugzillaApi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FILIP on 2/4/2018.
 */
public class BugzilaBug extends BugzillaApi {

    String product;
    String priority;
    Date last_change_time;
    String id;
    String status;
    String apiresponse;
    List<BugzilaBug> buglist;
    BugzilaBug bug;


    public BugzilaBug() {

    }


    private List<BugzilaBug> getPlaformCollection() throws IOException {

        buglist=new ArrayList<>();
        Gson gson=new Gson();
        JsonElement element = gson.fromJson (apiresponse, JsonElement.class);
        JsonArray object = (JsonArray) element.getAsJsonObject().get("bugs");

        for (int i = 0; i < object.size(); i++) {
            JsonObject objectJSON = (JsonObject) object.get(i);
            BugzilaBug bug1 =gson.fromJson(objectJSON,BugzilaBug.class);
            buglist.add(bug1);
        }

        return buglist;

    }

    public BugzilaBug getBug() {
        if (buglist != null) {
            for (BugzilaBug bug : buglist) {
                return bug;
            }
        }
        return bug;

    }


    public String getPriority() {
        return priority;
    }

    public Date getLast_change_time() {
        return last_change_time;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    private String getApiresponse(){
        apiresponse=getResponse().toString();
        return apiresponse;
    }

    public static void main(String args[]) throws IOException {

        BugzilaBug b=new BugzilaBug();
        b.getNrOfBugsOpen();
        b.getApiresponse();
        b.getPlaformCollection();
        System.out.println("Bug Priority is: "+b.getBug().getPriority());

    }




}