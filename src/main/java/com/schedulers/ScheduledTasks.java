package com.schedulers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.JdbcSessionDatabaseInitializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import com.services.ProcessingService;

@Component
public class ScheduledTasks {
	@Autowired
	ProcessingService processingService;
	
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 50000000)
    public void reportCurrentTime() throws InterruptedException {
    	 //Thread.sleep(10000);
    	//processingService.processingMethod();
        log.info("The time is now {}", dateFormat.format(new Date()));
    	Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
		concurrentHashMap.put(10, "Amogh");
		concurrentHashMap.put(20, "Santhosh");
		concurrentHashMap.put(30, "Arun");
		concurrentHashMap.put(40, "Ramesh");
		concurrentHashMap.put(50, "Suresh");
		concurrentHashMap.put(60, "Suresh");
		int count1 = 0;
		for(Entry<Integer,String> entry : concurrentHashMap.entrySet()){
			if(entry.getValue().equals("Suresh")){
				count1++;
			}
		}
		
		long count = concurrentHashMap
		.entrySet()
		.parallelStream()
		.filter(obj -> obj.getValue().equals("Suresh"))
		.count();
		
		System.out.println(count);
		
		System.out.println(concurrentHashMap.entrySet());
		System.out.println(concurrentHashMap.entrySet().parallelStream());
		
		
		//processingService.processingMethod();
		
		processingService.getEmployeeDetails();
		
    
    }
}