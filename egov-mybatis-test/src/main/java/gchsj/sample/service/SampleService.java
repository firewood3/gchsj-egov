package gchsj.sample.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import gchsj.sample.mapper.SampleMapper;
import gchsj.sample.model.Sample;

@Service("sampleService")
public class SampleService {
	
	@Resource(name="sampleMapper")
	private SampleMapper sampleMapper;
	
	public List<Sample> selectList() {
		return sampleMapper.selectList(new Sample());
	}
}
