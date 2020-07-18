package g_builder;

public class InnerBuilderNetRequest {
    private String url;
    private String method;
    private String header;
    private String body;

    public InnerBuilderNetRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.header = builder.header;
        this.body = builder.body;
    }

    public void makeCall(){
        System.out.println("我现在可以发起网络请求了，相应信息为：url：" +url + ",method:" + method + ",header:"
        + header + ",body:" + body);
    }

    public static class Builder{
        private String url;
        private String method;
        private String header;
        private String body;


        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }


        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }


        public Builder setHeader(String header) {
            this.header = header;
            return this;
        }


        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public InnerBuilderNetRequest build(){
            return new InnerBuilderNetRequest(this);
        }
    }
}
