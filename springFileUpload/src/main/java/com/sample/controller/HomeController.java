package com.sample.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload2(Locale locale, Model model) {

		return "upload";
	}

		
	@RequestMapping(value = "requestupload2")
	public String requestupload2(MultipartHttpServletRequest mtfRequest) {
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		String src = mtfRequest.getParameter("src");
		System.out.println("src value : " + src);

		String path = "C:\\develop\\workspace\\upload\\";

		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈

			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);

			String safeFile = path + originFileName;
			System.out.println(safeFile);
			try {
				mf.transferTo(new File(safeFile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/execution";

	}
	//@RequestMapping(value = "prago")
	//public void execute() throws IOException{
	//	String s = "", totalStr = "";
	//	String param1 = "C:\\develop\\workspace\\upload\\";
	//	
	//	ProcessBuilder builder = new ProcessBuilder("C:\\Users\\suser001\\Desktop\\test\\PrimedRPA.py","py","s1_para.txt");
	//	builder.directory(new File(param1));
	//	
	//	Process oProcess = builder.start();
	//	
	//	BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
	//	BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
	//	stdError.close();
		
	//}
	
	public static class runtimetest{
		public static void main(String[] args) throws IOException, InterruptedException{
			Runtime rt = Runtime.getRuntime();
			Process pc = null;
			try {
				pc = rt.exec("cmd.exe");
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				pc.waitFor();
			
			}
		}
	}

}
