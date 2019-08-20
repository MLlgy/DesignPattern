package chains.origin;

public interface IHandler {

    /**
     * 设置请求的下一个处理者
     * @param handler
     */
    void setNextHandler(IHandler handler);

    /**
     *
     * @param request 需要处理请求
     * @return 处理结果
     */
    Response doRealWork(Request request);


}
