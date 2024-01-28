public class CustomExceptions {

    // custom exception bsp:
    public class NotEnoughException extends Exception{
        private static final String message = "Not enough! Should be: ";
        private final int should;
        private final int is;

        public NotEnoughException(int should, int is){
            if (is<should) {
                this.should = should;
                this.is = is;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        public String toString(){
            return message + should + " but is: " + is;
        }

        public int getIs() {
            return is;
        }

        public int getShould() {
            return should;
        }
    }


    // checking and throwing exceptions:
    public void checkFormatWithLogging(String pwd) throws NotEnoughException, IllegalCharException {
        try {
            checkFormat(pwd);
        } catch (NotEnoughException | IllegalCharException e) {
            System.out.println(e);
            throw e;
        }
    }
}
