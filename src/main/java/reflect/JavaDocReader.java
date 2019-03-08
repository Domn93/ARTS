package reflect;

import com.sun.javadoc.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author maqingze
 * @version v1.0
 * @date 2019/3/5 16:03
 */
public class JavaDocReader {
   /* public static boolean start(RootDoc root) throws IOException {
        for (ClassDoc c : root.classes()) {
            print(c.qualifiedName(), c.commentText());
            for (FieldDoc f : c.fields(false)) {
                print(f.qualifiedName(), f.commentText());
            }
            for (MethodDoc m : c.methods(false)) {
                print(m.qualifiedName(), m.commentText());
                if (m.commentText() != null && m.commentText().length() > 0) {
                    for (ParamTag p : m.paramTags()){
                        print(m.qualifiedName() + "@" + p.parameterName(), p.parameterComment());
                    }
                    for (Tag t : m.tags("return")) {
                        if (t.text() != null && t.text().length() > 0){
                            print(m.qualifiedName() + "@return", t.text());
                        }
                    }
                }
            }
        }
        return true;
    }

    private static void print(String name, String comment) throws IOException {
        if (comment != null && comment.length() > 0) {
            new FileWriter(name + ".txt").append(comment).close();
        }
    }*/

    private static RootDoc root;

    // 一个简单Doclet,收到 RootDoc对象保存起来供后续使用
    // 参见参考资料6
    public static class Doclet {

        public Doclet() {
        }

        public static boolean start(RootDoc root) {
            JavaDocReader.root = root;
            return true;
        }
    }

    // 显示DocRoot中的基本信息
    public static void show() {
        ClassDoc[] classes = root.classes();
        for (int i = 0; i < classes.length; ++i) {
            System.out.println(classes[i]);
            System.out.println(classes[i].commentText());
            for (MethodDoc method : classes[i].methods()) {
                System.out.printf("\t%s\n", method.commentText());
            }
        }
    }

    public static RootDoc getRoot() {
        return root;
    }

    public JavaDocReader() {

    }

    public static void main(final String... args) throws Exception {
        // 调用com.sun.tools.javadoc.Main执行javadoc,参见 参考资料3
        // javadoc的调用参数，参见 参考资料1
        // -doclet 指定自己的docLet类名
        // -classpath 参数指定 源码文件及依赖库的class位置，不提供也可以执行，但无法获取到完整的注释信息(比如annotation)
        // -encoding 指定源码文件的编码格式
        com.sun.tools.javadoc.Main.execute(new String[]{"-doclet",
                        Doclet.class.getName(),
// 因为自定义的Doclet类并不在外部jar中，就在当前类中，所以这里不需要指定-docletpath 参数，
//              "-docletpath",
//              Doclet.class.getResource("/").getPath(),
                        "-encoding", "utf-8",
                "-classpath",
                "D:/j/facelog/facelog-main/target/classes",
// 获取单个代码文件FaceLogDefinition.java的javadoc
                "D:\\ideaWorkSpace\\ARTS\\src\\main\\java\\jmx\\Main.java"});
        show();
    }
}
