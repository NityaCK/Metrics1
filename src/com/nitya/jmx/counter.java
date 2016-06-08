package com.nitya.jmx;

import java.io.*;

public class counter implements counterMBean
{

    private int res;
    private String filename;

    counter()
    {
        res = 0;
        filename = null; //test2.txt
    }

    counter(String filename)
    {
        this.res=0;
        this.filename=filename;
        readfromfile();
    }

    private int wordcount (String s)
    {
        char ch[]= new char[s.length()];
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            ch[i]= s.charAt(i);
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                c++;
        }
        return c;
    }

    public void readfromfile()
    {
        String line=null;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            do
            {
                line = reader.readLine();
                if(line==null) break;
                int x = wordcount(line);
                res=res+x;
            }while(line!=null);
        }
        catch(FileNotFoundException f){System.out.println("sorry file not found");}
        catch(IOException io){System.out.println("io exception");}

    }

    @Override
    public int getWordCount()
    {
        return this.res;
    }

    @Override
    public void setFileName(String fname)
    {
        this.filename=fname;
    }

    @Override
    public String getFileName()
    {
        return this.filename;
    }

    @Override
    public void setWordCount(int count) {this.res=count;}

}
