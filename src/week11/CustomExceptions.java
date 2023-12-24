package week11;

public class CustomExceptions {
    public class AgeLessThanZeroIllegalException extends IllegalArgumentException{
        public AgeLessThanZeroIllegalException(String message, Throwable cause)
        {
            super(message,cause);
        }
        public void validateAgeThrowableMessage(int age) throws AgeLessThanZeroIllegalException
        {
            if(age<0)
            {
                throw new AgeLessThanZeroIllegalException("Problem", new RuntimeException());
            }
        }
    }

}
