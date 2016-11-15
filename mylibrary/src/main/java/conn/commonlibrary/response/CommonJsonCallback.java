package conn.commonlibrary.response;

import android.os.Handler;
import android.os.Looper;

import org.json.JSONObject;

import java.io.IOException;

import conn.commonlibrary.listener.DisposeDataListener;
import conn.commonlibrary.listener.DisposeDatahHandle;
import conn.commonlibrary.okhttp.OkHttpExcepthion;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lxy on 16-11-14.
 */

public class CommonJsonCallback implements Callback{

    protected final String RESULT_CODE ="ecode";
    protected final int RESULT_CODE_VALUE=0;
    protected final String ERROR_MSG="emsg";
    protected final String EMPTY_MSG="";
    protected final int OTHER_ERROR=-3;


    protected final int NETWORK_ERROR =-1;
    protected final int JSON_ERROR=-2;

    private DisposeDataListener mlistener;
    private Class<?> mClass;
    private Handler mDelieverHandler;

    public CommonJsonCallback(DisposeDatahHandle handle)
    {
        mlistener=handle.mListener;
        mClass=handle.mClass;
        mDelieverHandler =new Handler(Looper.getMainLooper());
    }
    @Override
    public void onFailure(Call call, final IOException e) {
        mDelieverHandler.post(new Runnable() {
            @Override
            public void run() {

                mlistener.onFailure(e);
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        //run in son thread
        final  String result =response.body().string();
        mDelieverHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });

    }

    private void handleResponse(String result){
        if(result==null || result.equals("")){
            mlistener.onFailure(new OkHttpExcepthion(NETWORK_ERROR,EMPTY_MSG));
            return;
        }
        try{
            /*JSONObject resultObj =new JSONObject(result);
            if (resultObj.has(RESULT_CODE))
            {
                if (resultObj.optInt(RESULT_CODE)==RESULT_CODE_VALUE){
                    if(mClass==null)
                    {
                        mlistener.onSuccess(resultObj);
                    }else{
                        Object obj = ResponseEntityToModule.parseJsonObjectToModule(resultObj,mClass);//gson jiexi de fangfa
                        if(obj==null){
                            mlistener.onFailure(new OkHttpExcepthion(JSON_ERROR,EMPTY_MSG));
                        }else{
                            // on the step, our response is right
                            mlistener.onSuccess(obj);
                        }
                    }

                }else {
                    mlistener.onFailure(new OkHttpExcepthion(JSON_ERROR,EMPTY_MSG));
                }
            }*/
            mlistener.onSuccess(result);
        }catch (Exception e){
            mlistener.onFailure(new OkHttpExcepthion(OTHER_ERROR,e.getMessage()));
        }
    }
}
