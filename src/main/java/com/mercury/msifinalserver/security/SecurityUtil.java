package com.mercury.msifinalserver.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.msifinalserver.http.Response;

public class SecurityUtil {
	private static final ObjectMapper mapper = new ObjectMapper();
	// jackson: convert from json to object, object to json

    // static, util function
	public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
    	    // HttpServletResponse: JSPDemo, servlet, spring also have dispatcher servlet
		// generate information
        response.setContentType("application/json;charset=UTF-8"); // response header, content type
        PrintWriter writer = response.getWriter(); // JSPDemo servlet, doGet(), append to response body
        writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message)));
        // convert object to json (a String), a new response from Response class
        // pass in status, message
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
	// call by 5 handlers
}