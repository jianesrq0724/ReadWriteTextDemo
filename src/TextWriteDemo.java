import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class TextWriteDemo {
    public static void main(String[] args) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "E:\\new_password_1.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
//

            FileReader fileReader = new FileReader(pathname);
            BufferedReader bfReader = new BufferedReader(fileReader, 5 * 1024 * 1024);


            /* 写入Txt文件 */
            FileWriter fWriter = new FileWriter(".\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            BufferedWriter bfWriter = new BufferedWriter(fWriter);
            List<String> arrayList = new ArrayList<>();
            HashSet<String> set = new HashSet<String>();

            String lineTxt;
            while ((lineTxt = bfReader.readLine()) != null) {
                if (lineTxt != null && lineTxt.length() != 0) {
                    lineTxt = lineTxt.trim();

                    if (lineTxt.length() != 0 && !Pattern.compile("[\u4e00-\u9fa5]").matcher(lineTxt).find()) {
                        if (set.add(lineTxt)) {
                            arrayList.add(lineTxt);
                        }
                    }
                }
            }


            for (int i = 0; i < arrayList.size(); i++) {
                bfWriter.write(arrayList.get(i) + "\r\n"); // \r\n即为换行
            }

//            out.write("我会写入文件啦\r\n"); // \r\n即为换行
            bfWriter.flush(); // 把缓存区内容压入文件
            bfWriter.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
