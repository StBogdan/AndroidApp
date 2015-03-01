package com.example.bogdan.reteta;

import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan on 01/03/2015.
 */
public class GetRecipe  extends AsyncTask {
    JSONParser jParser = new JSONParser();
    JSONArray products = null;
    String returned;

    protected Object doInBackground(Object[] params){
        String url_all_products = "http://localhost/android_connect/get_all_products.php";

        List<NameValuePair> perems = new ArrayList<NameValuePair>();
        JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", perems);

        try {returned = json.getJSONArray("products").toString();}
        catch (Exception e)
        { e.printStackTrace();}
        publishProgress(returned);
    return "Finished getting data";
    }

}
