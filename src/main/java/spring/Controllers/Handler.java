package spring.Controllers;


public class Handler{

}

/*
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 import java.io.OutputStream;
 import java.io.OutputStreamWriter;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.TimeZone;

 import com.amazonaws.services.dynamodbv2.document.Item;
 import com.amazonaws.services.dynamodbv2.document.ItemCollection;
 import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
 import com.amazonaws.services.dynamodbv2.document.Table;
 import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
 import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
 import com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
 import com.amazonaws.services.lambda.runtime.Context;
 import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

 import org.json.simple.JSONObject;
 import org.json.simple.parser.JSONParser;
 import org.json.simple.parser.ParseException;

 // You can use LambdaLogger.log(message); for debugging purposes.

 public class Handler implements RequestStreamHandler {

    private String getDateNow() {
    // Use the following date format for "now":
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    String dateNow = df.format(new Date());

    return dateNow;
    }

    private List<JSONObject> queryUserNotes(String userEmail) {

       List<JSONObject> myList = new ArrayList<JSONObject>();

       String dateNow = getDateNow();

       // For working with JSON objects, you can use following utilities:
       JSONParser parser = new JSONParser();
       List<JSONObject> resultItems = new ArrayList<>();

       String tableName = "user-notes";

       try {
       Table table = DynamoDBClient.client.getTable(tableName);

       // Query the DynamoDB database...

       QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("#yr = :yyyy").withNameMap(nameMap)
       .withValueMap(valueMap);


       return myList;

       } catch (Exception exc) {
       return null;
       }
    }

    // Keep this method static
    public static String getAuthenticatedUserEmail(String token) {
    String tableName = "token-email-lookup";

    try {
    Table table = DynamoDBClient.client.getTable(tableName);
    GetItemSpec getItemSpec = new GetItemSpec();

    Item item = table.getItem(getItemSpec);

    // Validate the given token with one from the database
    // and return user email if the tokens match ...

    return null;
    } catch (Exception exc) {
    return null;
    }
    }

    private String authenticateUser(JSONObject headers) {
    String authenticationHeader = (String) headers.get("Authentication");

    // Validate the Authentication header and retrieve token
    String token = null;

    String email = Handler.getAuthenticatedUserEmail(token);

    return email;
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
    JSONParser parser = new JSONParser();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    JSONObject responseJson = new JSONObject();
    OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");

    try {
    JSONObject event = (JSONObject) parser.parse(reader);
    JSONObject headers = (JSONObject) event.get("headers");

    String email = authenticateUser(headers);

    List<JSONObject> resultItems = new ArrayList<>();
    resultItems = queryUserNotes(email);

    responseJson.put("statusCode", 200);
    responseJson.put("body", resultItems.toString());

    } catch (Exception exc) {

    }

    writer.write(responseJson.toString());
    writer.close();
    }
 }
*/