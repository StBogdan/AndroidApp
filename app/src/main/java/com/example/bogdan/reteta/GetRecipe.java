package com.example.bogdan.reteta;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan on 01/03/2015.
 */
public class GetRecipe {
    JSONParser jParser = new JSONParser();
    JSONArray products = null;

    public String getRecipes(){
        String url_all_products = "http://localhost/android_connect/get_all_products.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);

        try{return json.getJSONArray("products").toString();}
        catch (Exception e)
        { e.printStackTrace(); return null;}
    }
}
