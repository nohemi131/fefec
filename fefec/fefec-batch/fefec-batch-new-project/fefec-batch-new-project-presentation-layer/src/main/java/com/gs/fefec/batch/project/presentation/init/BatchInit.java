package com.gs.fefec.batch.project.presentation.init;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchInit {
	private static Logger log = Logger.getLogger(BatchInit.class) ; 

	@SuppressWarnings({"resource","unused"})
	public static void main(String[] args) {
		DOMConfigurator.configure("properties/log4j.xml");
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/batch/jobs/job-confronta.xml"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Done");
	}
}
