package com.travel.ac.utils;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by lwh on 2016/5/4. description
 */
public class NetworkHelper
{
	private static final String	LOG_TAG	= "NetworkHelper";
	private RequestQueue		mRequestQueue;
	private StringRequest		mRequest;

	public boolean requestAndResponse(Activity activity, String url, Response.Listener<String> listener)
	{
		mRequestQueue = Volley.newRequestQueue(activity);
		mRequest = new StringRequest(Request.Method.POST, url, listener, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error)
			{
				error.printStackTrace();
			}
		});
		mRequestQueue.add(mRequest);
		mRequestQueue.start();
		return true;
	}

	public void cancel()
	{
		mRequestQueue.cancelAll(mRequest.getTag());
	}
}
