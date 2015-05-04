package com.lansfordhazel.jit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Junior on 03/05/2015.
 */
public class RestRequest {

    private final String url = "";

    enum type{yahoo,map}
   public String get() {
        //Http client
        DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());

        //Where to get the data from
        HttpPost httpPost = new HttpPost(url);

        //Defining they type of object being returned
        httpPost.setHeader("Content-type", "application/json");

        //used to read data from the URL
        InputStream inputStream = null;

        String result = null;

        try {
            //Gets the HTTP data
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            inputStream = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            String line = null;
            StringBuilder builder = new StringBuilder();
            //goes through data
            while ((line = reader.readLine()) != null)
                builder.append(line + "\n");

            result = builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Clean-up
        finally {
            try {
                if(inputStream !=null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}


