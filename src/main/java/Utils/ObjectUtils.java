package Utils;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtils{




    public static  MultivaluedMap convertListToMap(List<String> list){
        MultivaluedMap map=new MultivaluedMapImpl();
        for(String Element:list){
         String keyValuePair=Element;
          String[] Kv= keyValuePair.split("=");
              map.putSingle(Kv[0],Kv[1]);

           }
        return map;
    }



    public static void main(String args[]){

        List<String> test=new ArrayList<>();
        test.add("ana=mere");
        convertListToMap(test);


    }

        }