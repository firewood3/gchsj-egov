package gchsj.sample.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import gchsj.sample.model.Sample;
import gchsj.util.mapper.BaseMapper;

@Mapper (value="sampleMapper")
public interface SampleMapper extends BaseMapper<Sample, Sample>{

}
