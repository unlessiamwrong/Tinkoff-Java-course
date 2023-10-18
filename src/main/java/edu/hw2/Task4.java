package edu.hw2;

public class Task4 {

    public Task4() {

    }

    public record CallingInfo(String className, String methodName) {
        public static CallingInfo callingInfo() {
            var trace = new RuntimeException().getStackTrace()[1];
            String methodName = trace.getMethodName();
            String className = trace.getClassName();
            return new CallingInfo(className, methodName);

        }
    }
}
