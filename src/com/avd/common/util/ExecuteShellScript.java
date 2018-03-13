package com.avd.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellScript
{
    private static ExecuteShellScript instance;

    protected ExecuteShellScript()
    {
        super();
    }

    public static synchronized ExecuteShellScript getInstance()
    {
    	System.out.println("hello.. My first project");
        if(instance == null)
            instance = instantiate();

        return instance;
    }

    // Wanted to make this abstract and let subclasses @Override it,
    // but combining 'abstract' and 'static' is illegal; makes sense!
    protected static ExecuteShellScript instantiate()
    {
        return new ExecuteShellScript();
    }
	public static synchronized String executeScript(String script)
    {

		String ret="";
		Process p;
		
        try {  
        	
           
        	p = Runtime.getRuntime().exec(script);

            BufferedReader outReader1 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String read1=outReader1.readLine();
            int waitFor=0;
            waitFor=p.waitFor();
            ret=waitFor+" "+read1;
                 
        	}  
        catch (Exception e) {  
        	System.out.println("Exception--"+e);
        	ret="Exception "+e;
        }
        finally{
        	//if(p!=null)
        	//p.destroy();
        }
        return ret;

    }
	
	
    
}
