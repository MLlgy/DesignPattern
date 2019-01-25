package chains.interceptorChains;

public class FirstInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {// 其实在这里 chain 的真正的引用为 RealInterceptorChain
        //前
        String lastMessage = chain.handleMessage();
        System.out.println("FirstInterceptor -1.1- " + lastMessage);
        String message = chain.proceed(lastMessage + "First");// 会执行 RealInterceptorChain#intercept
        System.out.println("FirstInterceptor -1.2- " + message);
        // 后
        return message;
    }
}
