import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordDemo {
    static String mPathname = "D:\\MyJobInfo\\word\\middle_word_1.txt";
    static List<String> mWordArray = new ArrayList<>();
    //    static int mStartIndex = 2201;
    static int mStartIndex = 4;

    public static void main(String[] args) {


        FileReader fileReader;
        try {
            fileReader = new FileReader(mPathname);
            BufferedReader bfReader = new BufferedReader(fileReader, 5 * 1024 * 1024);
            String lineTxt;
            while ((lineTxt = bfReader.readLine()) != null) {
                if (lineTxt != null && lineTxt.length() != 0) {
                    mWordArray.add(lineTxt);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordDemo wordDemo = new WordDemo();
        wordDemo.printArray1();
//        wordDemo.printArray2();

    }

    private void printArray1() {
        System.out.println(mWordArray.size() + ", " + mStartIndex);

        for (int i = mStartIndex; i < mWordArray.size(); i++) {
            printText(i, mWordArray.get(i));
        }
    }

    private void printArray2() {
        System.out.println(mWordArray.size() + ", " + mStartIndex);
        int count = Math.min(mStartIndex, mWordArray.size());

        for (int i = count - 1; i >= 0; i--) {
            printText(i, mWordArray.get(i));
        }
    }

    private void printText(int index, String text) {
        System.out.println("    " + index + "、" + text);
        try {
//            Thread.sleep(5000);
//            Thread.sleep(3000);
//            Thread.sleep(2000);
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
