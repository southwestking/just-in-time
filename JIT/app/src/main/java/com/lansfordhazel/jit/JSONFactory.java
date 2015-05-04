package com.lansfordhazel.jit;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Junior on 04/05/2015.
 */
public class JSONFactory extends AsyncTask<String, String, String> {
    String result;
    @Override
    protected String doInBackground(String... params) {
        try {
            JSONObject json = new JSONObject(new RestRequest().get());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){

    }
}
