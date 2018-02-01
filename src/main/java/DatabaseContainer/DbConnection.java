package DatabaseContainer;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by andrei.filip on 1/17/2018.
 */
public class DbConnection {

     MongoClient mongoClient;
     MongoDatabase database;
     private static final String DbName="myMongoDb";



    private MongoClient getMongoClient() {
        return mongoClient;
    }


    public void getDatabases(){
        System.out.println("Databases created are:"+this.mongoClient.getDatabase(DbName));

    }


    public DbConnection(){
        this.mongoClient=new MongoClient();
       // createDataBase();


    }
     private void createCollection(){

        database.createCollection("customers", null);

    }


    private void createDataBase(){

         this.database = getMongoClient().getDatabase(DbName);

    }
    private MongoDatabase getDataBase(){

        return this.database;

    }



    public static void main(String args[]) {

        DbConnection con=new DbConnection();
      //  MongoDatabase database= con.getDataBase();
          //con.createCollection();
        DB a=con.getMongoClient().getDB("myMongoDb");

        DBCollection collection = a.createCollection("customers",null);
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insert(document);


    }




}
