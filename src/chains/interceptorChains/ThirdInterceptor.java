package chains.interceptorChains;

public class ThirdInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        //前
        String lastMessage = chain.handleMessage();
        System.out.println("ThirdInterceptor -3.1- " + lastMessage);
        String message = lastMessage + "Third";
        System.out.println("ThirdInterceptor -3.2- " + message);
        // 后
        return message;
    }
}
