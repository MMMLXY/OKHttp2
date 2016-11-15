package conn.commonlibrary.okhttp;

/**
 * Created by lxy on 16-11-14.
 */

public class OkHttpExcepthion extends Exception {
    private static final long serialVersionUID =1L;

    /**
     * the server return cod
     */
    private int ecode;

    /**
     * the server return error message
     */
    private Object emsg;

    public OkHttpExcepthion(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}
