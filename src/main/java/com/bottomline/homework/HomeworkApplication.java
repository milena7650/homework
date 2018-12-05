package com.bottomline.homework;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
	/*	JobParametersBuilder jobBuilder= new JobParametersBuilder();
	    jobBuilder.addString("command", "ipconfig");
	    JobParameters jobParameters =jobBuilder.toJobParameters();
*/
		SpringApplication.run(HomeworkApplication.class, args);
		   System.out.println("\n---------main-----------------");
		    System.out.println(Arrays.toString(args));
		    System.out.println("--------------------------");	   
	}
}
