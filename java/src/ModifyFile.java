/*
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-12-06 10:25:23
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-12-06 10:26:12
 * @Slogan: 無限進步
 */
import java.io.IOException;
import java.nio.file.Files; // 导入Files类，用于文件操作
import java.nio.file.Path; // 导入Path类，用于表示文件路径
import java.nio.file.Paths; // 导入Paths类，用于获取Path对象

public class ModifyFile {
    public static void main(String[] args) {
        Path path = Paths.get("a.txt"); // 获取表示文件a.txt的Path对象
        try {
            if (!Files.exists(path)) { // 如果文件不存在
                Files.createFile(path); // 创建文件
            }
            String content = new String(Files.readAllBytes(path)); // 读取文件内容并转换为字符串
            content += ",world"; // 在原内容后面添加",world"
            Files.write(path, content.getBytes()); // 将修改后的内容写入文件
            System.out.println("修改成功");
        } catch (IOException e) { // 捕获IO异常
            e.printStackTrace(); // 打印异常堆栈跟踪
        }
    }
}