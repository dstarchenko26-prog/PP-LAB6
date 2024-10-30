package ua.lpnu.menu;

public class simIOClass extends IOclass {
    int i;
    String str;
    String[] output = new String[0];

    public simIOClass (int i) {
        super();
        this.i = i;
    }

    public simIOClass(String str) {
        super();
        this.str = str;
    }

    public int InputInt() {
        return i;
    }

    public String InputStr() {
        return str;
    }

    public void print(String line) {
        String[] newList = new String[output.length + 1];
        System.arraycopy(output, 0, newList, 0, output.length);
        newList[output.length] = line;
        output = newList;
    }

    public void print(String[] lines) {
    }

    public int Input(int min, int max) {
        return i;
    }

    public String[] print() {
        return output;
    }
}
