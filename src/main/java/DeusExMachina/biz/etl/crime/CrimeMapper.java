package DeusExMachina.biz.etl.crime;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import DeusExMachina.biz.domain.analytics.sexoffender.SexOffender;

/**
 * Program Name : CrimeMapper
 * Description : 범죄자 정보 매퍼
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : WebMapper
 **/

public class CrimeMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {
        SexOffender sb = new SexOffender(value);
        Text outputKey = new Text();
        IntWritable outputValue = new IntWritable(1);
        if (CrimeService.reduceCount == 0)
        {
            outputKey.set(sb.getName() + "," + sb.getSido() + "," + sb.getGungu() + "," + sb.getRealResidence());
            context.write(outputKey, outputValue);
        }
        else if (CrimeService.reduceCount == 1)
        {
            outputKey.set(sb.getName());
            context.write(outputKey, outputValue);
        }
        else if (CrimeService.reduceCount == 2)
        {
            outputKey.set(sb.getSido());
            context.write(outputKey, outputValue);
        }
        else if (CrimeService.reduceCount == 3)
        {
            outputKey.set(sb.getGungu());
            context.write(outputKey, outputValue);
        }
        else if (CrimeService.reduceCount == 4)
        {
            outputKey.set(sb.getName() + "," + sb.getRealResidence());
            context.write(outputKey, outputValue);
        }
    }
}
