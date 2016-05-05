package com.travel.ac.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by lwh on 2016/5/4. description
 */
public class NetworkHelper {
    private static final String LOG_TAG = "NetworkHelper";
    private static RequestQueue  mRequestQueue;
    private static StringRequest mRequest;

    public static boolean requestAndResponse(final Activity activity, String url, Response.Listener<String> listener) {
        mRequestQueue = Volley.newRequestQueue(activity);
        mRequest = new StringRequest(Request.Method.GET, url, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity, "网络异常,请检查网络", Toast.LENGTH_LONG).show();
                Log.e(LOG_TAG, "onErrorResponse: " + error.getMessage());
            }
        });
        mRequestQueue.add(mRequest);
        mRequestQueue.start();
        return true;
    }

    public static void cancel() {
        mRequestQueue.stop();
    }

    public void cennetion(final Activity mActivity, String url) {
        RequestQueue queue = Volley.newRequestQueue(mActivity);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject resJson) {

                String jsonStr = null;
                try {
                    jsonStr = new String(resJson.toString().getBytes(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    Toast.makeText(mActivity, "获取数据失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                    return;
                }
                Log.e(LOG_TAG, "onResponse: " + jsonStr);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mActivity, "网络异常,请检查网络", Toast.LENGTH_LONG).show();
                Log.e(LOG_TAG, "onErrorResponse: " + error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
        queue.start();
    }
}
