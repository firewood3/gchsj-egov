package gchsj.sample.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gchsj.sample.model.Sample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:gchsj/spring/context-*.xml")
public class SampleServiceTest {
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@Test
	public void selectList() {
		List<Sample> sampleList = sampleService.selectList();
		System.out.println("[ Sample LIST ]");
		for (Sample sample : sampleList) {
			System.out.println("---> " + sample.toString());
		}
	}
}
