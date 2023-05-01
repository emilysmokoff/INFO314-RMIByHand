import java.io.Serializable;

public class RemoteMethod implements Serializable{
    private String methodName;
    private Object[] args;
    public Object[] result;

    public RemoteMethod(String methodName, Object[] args, Object[] result) {
        this.methodName = methodName;
        this.args = args;
        this.result = result;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getArguments() {
        return args;
    }

    public Object[] getResult() {
        return result;
    }

}