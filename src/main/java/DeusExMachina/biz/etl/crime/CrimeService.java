package DeusExMachina.biz.etl.crime;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Program Name : CrimeService
 * Description : 범죄자 정보 서비스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : WebController에서 분리
 **/

@Slf4j
public class CrimeService
{
    @Resource(name = "hdConf")
    Configuration conf;
    
    static int reduceCount;
    
    private String fileName = "sexOffender";
    
    public void cirmerMapReduceCall(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, InterruptedException
    {
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path("/result");
        if (hdfs.exists(path))
        {
            hdfs.delete(path, true);
        }
        for (reduceCount = 0; reduceCount < 5; reduceCount++)
        {
            log.debug("**************** " + reduceCount + "번째 시작 ****************");
            Job job = Job.getInstance(conf, "test");
            URI inputUri = URI.create("/input/csv/" + fileName + ".csv");
            URI outputUri = URI.create("/result/" + fileName + reduceCount);
            
            FileInputFormat.addInputPath(job, new Path(inputUri));
            job.setInputFormatClass(TextInputFormat.class);
            
            FileOutputFormat.setOutputPath(job, new Path(outputUri));
            job.setOutputFormatClass(TextOutputFormat.class);
            
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            
            job.setJarByClass(this.getClass());
            job.setMapperClass(CrimeMapper.class);
            job.setReducerClass(CrimeReducer.class);
            
            job.waitForCompletion(true);
            
            HashMap<String, Object> resultMap = new HashMap<String, Object>();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/json;charset=utf-8");
            JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultMap));
            resp.getWriter().write(json.toString());
        }
        log.debug("**************** 종료 ****************");        
    }
}
