package ua.lpnu.menu;

public class simListIOclass extends simIOClass{
    int[] array;

    public simListIOclass(int[] array) {
        super(0);
        this.array = array;
    }

    public simListIOclass(int[] array, String str) {
        super(str);
        i = 0;
        this.array = array;
    }


    public int Input(int min, int max) {
        i++;
        return array[i - 1];
    }

    public int InputInt() {
        i++;
        return array[i - 1];
    }
}
