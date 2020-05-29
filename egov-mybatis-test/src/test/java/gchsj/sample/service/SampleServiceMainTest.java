package gchsj.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import gchsj.sample.model.Sample;

public class SampleServiceMainTest {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext container = new GenericXmlApplicationContext("gchsj/spring/context-*.xml");
		
		SampleService sampleService = (SampleService) container.getBean("sampleService");
		
		List<Sample> sampleList = sampleService.selectList();
		System.out.println("[ Sample LIST ]");
		for (Sample sample : sampleList) {
			System.out.println("---> " + sample.toString());
		}

		int i = 0;
		
		container.close();
		
	}
}
