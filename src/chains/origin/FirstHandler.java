package chains.origin;

public class FirstHandler implements IHandler {
    @Override
    public void setNextHandler(IHandler handler) {

    }

    @Override
    public Response doRealWork(Request request) {
        return null;
    }
}
