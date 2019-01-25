package chains.interceptorChains;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testInterceptor();
    }


    private static void testInterceptor() {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new FirstInterceptor());
        interceptors.add(new SecondInterceptor());
        interceptors.add(new ThirdInterceptor());
        Interceptor.Chain chain = new RealInterceptorChain(interceptors, 0, "originStr\t");
        String endStr = chain.proceed("originStr\t");
        System.out.println("endstr\t" + endStr);
    }
}
