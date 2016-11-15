package conn.commonlibrary;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import conn.commonlibrary.listener.DisposeDatahHandle;
import conn.commonlibrary.response.CommonJsonCallback;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lxy on 16-11-14.
 */

public class CommonOkHttpClient {

    private static final int TIME_OUT =30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder okHttpBuiler =new OkHttpClient.Builder();
        /*okHttpBuiler.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });*/
        okHttpBuiler.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuiler.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpBuiler.writeTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpBuiler.followRedirects(true);



        mOkHttpClient = okHttpBuiler.build();
    }

    public static void post(Request request, DisposeDatahHandle handle){
        Call call =mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
    }

    public static  void get(Request request,DisposeDatahHandle handle){
        Call call =mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
    }
}
