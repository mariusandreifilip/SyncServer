package ResourceAPIs;

import Api.HttpClient;
import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

import java.util.Arrays;
import java.util.List;

import static Constants.ApiConstants.BugsUrl;
import static Constants.ApiConstants.ProductUrl;
import static Utils.ObjectUtils.convertListToMap;

/**
 * Created by andrei.filip on 1/22/2018.
 */

//GET https://bugzilla.mozilla.org/rest/bug?product=Foo&product=Bar

    /*
    * # Python example, you get a token back that you can use for future calls
>>> r = requests.get('https://bugzilla.mozilla.org/rest/login?login=username&password=password')
>>> r
<Response [200]>
>>> r.text
u'{"id":272475,"token":"272345-L1KydUNCwq"}'*/


public class BugzillaApi {


    HttpClient httpClient;
    Object resultedObject;

    List<String> BugQueryParams = Arrays.asList("product=Core", "component=Canvas: 2D", "status=NEW");
    List<String> ProductQueryParams = Arrays.asList("names=core","component=canvas_2d","status=open");




    BugzillaApi() {
        httpClient = new HttpClient();
    }


    public void getNrOfBugsOpen() {
        try {
            httpClient.generateUrl("GET", BugsUrl, convertListToMap(BugQueryParams), false);

        } catch (InternalRuntimeError error) {
            System.out.print(error);

        }

    }

    public void getProduct() {
        try {
            httpClient.generateUrl("GET", ProductUrl, convertListToMap(ProductQueryParams), false);

        } catch (InternalRuntimeError error) {
            System.out.print(error);

        }

    }


    public void getResponse() {

        resultedObject = httpClient.getResponseJson();
       // System.out.println("Nr of bugs="+resultedObject.getJSONArray("bugs").length());
    }

    public static void main(String args[]) {
        BugzillaApi login = new BugzillaApi();

        login.getNrOfBugsOpen();
        login.getResponse();


    }


}
