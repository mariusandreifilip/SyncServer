package Api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MultivaluedMap;

public class HttpClient {


    public  WebResource webResource;
    public  Object responseObject;
    Object PayloadObject;




    public HttpClient(){

    }

    private static Client connectClient(){
        Client client=Client.create();
        return client;



    }

    public  WebResource generateUrl(String operation, String url, MultivaluedMap<String,String> queryParams,Boolean BugzillaApi){
       BugzillaApi=false;
        switch (operation){
            case HttpMethod.GET:{

                if(queryParams!=null) {

                    webResource = connectClient().resource(url).queryParams(queryParams);
                    System.out.println("API EXECUTED:"+webResource.getURI());
                }else{
                    webResource = connectClient().resource(url);
                    System.out.println("API EXECUTED:"+webResource.getURI());
                }
            }

            case HttpMethod.POST:{
               /* try {
                    connectClient().resource(url).post(this.PayloadObject);
                }
                catch(InternalRuntimeError e){
                    System.out.print(e);

                }
*/
                //to update if needed
            }
            case HttpMethod.PUT:{
              /*  try {
                    connectClient().resource(url).put(this.PayloadObject);
                }
                catch(InternalRuntimeError e){
                    System.out.print(e);

                }*/
                //to update if needed
            }
            case HttpMethod.DELETE:{
               /* try {
                    connectClient().resource(url).delete(this.PayloadObject);
                }
                catch(InternalRuntimeError e){
                    System.out.print(e);

                }*/
                //to update if needed
            }
        }

       //setHeaders
        webResource.accept("application/json");
        if(BugzillaApi){
            webResource.header("X-BUGZILLA-API-KEY","ZeYKpFVGpLeGbLN19AuhHuQwfAv4zoULbHkftCZP");
        }


       return webResource;
    }



    public void setPayload(Object Payload){

        this.PayloadObject=Payload;
    }

    public Object getPayload(){

        return PayloadObject;
    }



    private   String getResponse(){
        ClientResponse response = null;
        String responseObject = null;
        try {
            response = webResource.accept("application/json").get((ClientResponse.class));

            responseObject= response.getEntity(String.class);
            System.out.println("STATUS CODE:"+response.getStatusInfo().getStatusCode());


        }
        catch(InternalError e){
            System.out.print(e);
            
        }

        if (response.getStatus() != 200) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return responseObject;


    }

    public Object getResponseJson(){
        this.responseObject=getResponse();
        System.out.println("RESPONSE OBJECT:"+responseObject);
        return responseObject;

    }





}