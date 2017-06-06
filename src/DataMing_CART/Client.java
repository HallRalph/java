package DataMing_CART;

/**
 * datou on 2017/6/6.
 */
public class Client {
    public static void main(String[] args) {
        String filePath = "D:/code/java/input.txt";

        CARTTool tool = new CARTTool(filePath);

        tool.startBuildingTree();
    }
}
