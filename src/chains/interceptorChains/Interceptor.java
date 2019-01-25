package chains.interceptorChains;

public interface Interceptor {
    //拦截链 返回值为最后需要的信息
    String intercept(Chain chain);

    interface Chain {
        /**
         *
         * @return 上个拦截器的信息
         */
        String handleMessage();

        /**
         * 触发执行下一个拦截器
         * @param message 传给下一个拦截器的信息
         * @return
         */
        String proceed(String message);
    }
}
