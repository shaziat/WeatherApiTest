package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class RestAssuredExtension {

    public static RequestSpecification Request;
    //Constructor
    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://www.metaweather.com/api");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }


    public static ResponseOptions<Response> GetOps(String url) throws URISyntaxException {
        return Request.get(new URI(url));
   }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String, String> pathParams)  {
       // public static ResponseOptions<Response> GetWithPathParams(String url, String pathParams)  {
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static String getCurrentDate1() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String getCurrentDate2() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        return strDate;
    }

}