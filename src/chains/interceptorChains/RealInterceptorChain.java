package chains.interceptorChains;

import java.util.List;

public class RealInterceptorChain implements Interceptor.Chain {

    private int index;//拦截器个数
    private String originStr;
    private List<Interceptor> interceptors;

    public RealInterceptorChain(List<Interceptor> interceptors, int index, String originStr) {
        this.index = index;
        this.originStr = originStr;
        this.interceptors = interceptors;
    }

    @Override
    public String handleMessage() {
        return originStr;
    }

    @Override
    public String proceed(String inputMessage) {
        if (index >= interceptors.size()) throw new AssertionError();
        RealInterceptorChain next = new RealInterceptorChain(interceptors, index + 1, inputMessage);
        Interceptor interceptor = interceptors.get(index);
        String response = interceptor.intercept(next);

        return response;
    }
}
