package com.cg.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.customermanagement.items.ui.ItemsUI;
//import com.cg.customermanagement.ui.CustomerMain;

@SpringBootApplication
public class CustomermanagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(CustomermanagementApplication.class, args);
		//CustomerMain customerMain=context.getBean(CustomerMain.class);
		//customerMain.start();
		ItemsUI itemMain = context.getBean(ItemsUI.class);
		itemMain.start();
	}

}
