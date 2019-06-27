package com.java.sol;

import org.apache.hadoop.io.Text;

public class SoBean
{
    
    String name;
    
    String sido;
    
    String gungu;
    
    String residence;
    
    String realResidence;
    
    public SoBean(Text value)
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
