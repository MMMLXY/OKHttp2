package conn.commonlibrary.listener;

/**
 * Created by lxy on 16-11-14.
 */

public interface DisposeDataListener {

    public void onSuccess(Object responseObj);
    public void onFailure(Object reasonObj);
}
