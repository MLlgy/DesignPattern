package chains.interceptorChains;

public class SecondInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        //前
        String lastMessage = chain.handleMessage();
        System.out.println("SecondInterceptor -2.1- " + lastMessage);
        String message = chain.proceed(lastMessage + "Second");
        System.out.println("SecondInterceptor -2.2- " + message);
        // 后
        return message;
    }
}
