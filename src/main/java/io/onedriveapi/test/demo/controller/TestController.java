package io.onedriveapi.test.demo.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.onedriveapi.test.demo.DemoApplication;

@RestController
@RequestMapping("/")
public class TestController {

	@RequestMapping("googledrivetest")
	public void hello(HttpServletRequest request) throws IOException, JSONException {
		String code = request.getQueryString();
		Pattern pattern = Pattern.compile("code=(.*?)&scope");
		Matcher matcher = pattern.matcher(code);
		if (matcher.find())
		{
		    System.out.println(matcher.group(1));
		}
		code = (String) matcher.group(1);
		System.out.println(code);
		DemoApplication.testapi(code);
		
	}
	
}
