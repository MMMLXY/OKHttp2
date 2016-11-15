package conn.commonlibrary.request;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lxy on 16-11-14.
 */

public class RequestParams {
    public ConcurrentHashMap<String,String> urlParams =new ConcurrentHashMap<>();
    //public ConcurrentHashMap<String,Object> fileParams =new ConcurrentHashMap<>();


    public RequestParams(Map<String,String> source)
    {
        if (source!=null)
        {
            for (Map.Entry<String,String> entry:source.entrySet())
            {
                put(entry.getKey(),entry.getValue());
            }
        }
    }
    void put(String key,String value)
    {
        urlParams.put(key,value);
    }
}
