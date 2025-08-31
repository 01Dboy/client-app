public class Package implements Runnable {

    @Override
    public void run() {

        UserInput userInput = new UserInput();

        String signature = PackageSignature.getSignature();
        String dataType = dataType(userInput.call());

    }


    private String dataType (int number) {

        switch (number) {
            case 1: return "CONSOLE";
            case 2: return "PLAIN  ";
            case 3: return "JSON   ";
            default: return "";
        }

    }

}
