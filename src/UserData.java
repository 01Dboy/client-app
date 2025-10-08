
public class UserData {

    private final String data;
    private final int choice;

    public UserData(int choice, String data ) {
        this.data = data;
        this.choice = choice;
    }

    public String getData() {
        return data;
    }

    public int getChoice() {
        return choice;
    }

}
