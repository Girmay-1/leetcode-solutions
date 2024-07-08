public class TryGeneratedException {
    GenerateException generateException;
    public void tryGeneratedExceptionMethod(){
        generateException = new GenerateException();
        try {
            if(generateException.returnObject(1) == null)
                throw new NullPointerException();
            System.out.println("exception not caught");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception caught");
        }
    }

    public static void main(String[] args) {
        TryGeneratedException tryGeneratedException = new TryGeneratedException();
        tryGeneratedException.tryGeneratedExceptionMethod();
    }
}
