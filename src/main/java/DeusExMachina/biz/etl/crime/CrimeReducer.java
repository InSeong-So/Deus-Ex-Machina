package DeusExMachina.biz.etl.crime;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Program Name : CrimeReducer
 * Description : 범죄자 정보 리듀서
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : WebReducer
 **/

public class CrimeReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
    
    @Override
    protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException
    {
        int cnt = 0;
        for (IntWritable v : value)
        {
            cnt += v.get();
        }
        IntWritable result = new IntWritable();
        result.set(cnt);
        context.write(key, result);
    }
}
