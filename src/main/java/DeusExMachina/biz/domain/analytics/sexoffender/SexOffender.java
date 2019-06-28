package DeusExMachina.biz.domain.analytics.sexoffender;

import org.apache.hadoop.io.Text;

/**
 * Program Name : SexOffender
 * Description : 성범죄자 테이블
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : SoBean
 **/

public class SexOffender
{
    
    String name;
    
    String sido;
    
    String gungu;
    
    String residence;
    
    String realResidence;
    
    public SexOffender(Text value)
    {
        try
        {
            String[] col = value.toString().split(",");
            setName(col[0] == null ? "" : col[0]);
            setSido(col[1] == null ? "" : col[1]);
            setGungu(col[2] == null ? "" : col[2]);
            setResidence(col[3] == null ? "" : col[3]);
            setRealResidence(col[4] == null ? "" : col[4]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getSido()
    {
        return sido;
    }
    
    public void setSido(String sido)
    {
        this.sido = sido;
    }
    
    public String getGungu()
    {
        return gungu;
    }
    
    public void setGungu(String gungu)
    {
        this.gungu = gungu;
    }
    
    public String getResidence()
    {
        return residence;
    }
    
    public void setResidence(String residence)
    {
        this.residence = residence;
    }
    
    public String getRealResidence()
    {
        return realResidence;
    }
    
    public void setRealResidence(String realResidence)
    {
        this.realResidence = realResidence;
    }
    
    @Override
    public String toString()
    {
        return "CriminalBean [name=" + name + ", sido=" + sido + ", gungu=" + gungu + ", residence=" + residence + ", realResidence=" + realResidence + "]";
    }
}
