package com.the_incognito.darry.my_application2;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    private HashMap<String, String> params;
    private static final String LOGIN_REQUEST_URL = "http://192.168.1.21:8080/incongnitomessenger/webapi/auth/login";
    //private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<JSONObject> listener) {
        //super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        System.out.println("name is :"+username);
        System.out.println("password is :"+password);

        JsonObjectRequest req = new JsonObjectRequest(LOGIN_REQUEST_URL, new JSONObject(params),
                listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: SOme error", error.getMessage());
            }
        });
        LoginActivity.getInstance().addToRequestQueue(req);
    }
}
