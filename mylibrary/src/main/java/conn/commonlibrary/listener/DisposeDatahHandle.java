package conn.commonlibrary.listener;

/**
 * Created by lxy on 16-11-14.
 */

public class DisposeDatahHandle {
    public DisposeDataListener mListener=null;
    public Class<?> mClass =null;

    public DisposeDatahHandle(DisposeDataListener listener){

        mListener=listener;
    }

    public DisposeDatahHandle(DisposeDataListener listener,Class<?> clazz){

        mListener=listener;
        mClass=clazz;
    }
}
