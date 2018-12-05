package com.bottomline.homework;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public SystemCommandTasklet taskletStep;
    
    @Bean
    @StepScope
    public SystemCommandTasklet task1(@Value("#{jobParameters[command]}") String command) {
      SystemCommandTasklet tasklet = new SystemCommandTasklet();
      tasklet.setCommand(command);
      tasklet.setTimeout(5000);
      return tasklet;
    }
    
    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJob")  
        		 .incrementer(new RunIdIncrementer())
        		 .start(step1())
                .build();
    }
    
    @Bean
    public TaskletStep step1() {
        return stepBuilderFactory.get("step1")
        		.tasklet(taskletStep)
                .build();
    }
}
