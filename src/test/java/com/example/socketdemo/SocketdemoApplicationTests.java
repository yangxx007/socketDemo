package com.example.socketdemo;

import com.example.socketdemo.service.PyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocketdemoApplicationTests {
	@Autowired
	private PyService service;
	@Test
	public void contextLoads() {
//		PythonInterpreter interpreter = new PythonInterpreter();
//		interpreter.execfile("/home/wcsn/yang-workspace/javaweb/client.py");
		service.start(1);
		System.out.println(service.read());
	}

}
