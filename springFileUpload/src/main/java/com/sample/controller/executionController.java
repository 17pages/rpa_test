package com.sample.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class executionController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@RequestMapping(value = "/execution", method = RequestMethod.GET)
	public String upload2(Locale locale, Model model) {

		return "execution";
}
	
	@RequestMapping(value ="execution")
	public void Cmd() throws IOException{
		String[] cmd = new String[] {"cmd", "/c", "dir"};
		Process prosess = null;
		String str = null;
		
		try {
			Process process = new ProcessBuilder(cmd).start();
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			While((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}
}