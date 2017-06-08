package bank;
/**
 * * datou on 2017/4/1.
 */
import java.sql.*;
import java.util.*;

public class Account {

    /**
     * 用以实现用户的注册和登录
     */
    private static String url="jdbc:mysql://localhost:3306/bam";//连接数据库的url，test是我自己的一个数据库啊宝宝们。
    private static String user="root";//mysql登录名
    private static String pass="123456";//mysql登录密码
    private static Connection con;//

    static Scanner input =new Scanner(System.in);
    private static int id;
    private static String username;
    private static String password;
    private static String personId;
    private static String email;
    private static float balance;
    private static float ceiling;
    private static int usertype;    //1:借记卡    2:信用卡

    public static void main(String[] args) throws Exception {
        //加载数据库连接驱动并连接
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url,user,pass);
        init();
    }

    //主菜单
    public static void init() throws SQLException {
        System.out.println("请选择:    1.用户登录    2.用户注册    3.统计    4.退出系统");
        int i=input.nextInt();
        switch(i){
            case 1:
                denglu();
                break;
            case 2:
                zhuce();
                break;
            case 3:
                System.out.println("请选择:    1.统计银行所有账户余额总数    2.统计所有信用账户透支额度总数");
                int ch=input.nextInt();
                float sum=0;
                String sql;
                PreparedStatement ptmt;
                ResultSet rs;
                switch (ch){
                    case 1:
                        sql="select * FROM users";
                        ptmt=con.prepareStatement(sql);
                        rs=ptmt.executeQuery();
                        while (rs.next()){
                            sum+=rs.getFloat("balance");
                        }
                        System.out.println("所有账户余额总数:"+sum);
                        init();
                        break;
                    case 2:
                        sql="select ceiling FROM users WHERE usertype=2";
                        ptmt=con.prepareStatement(sql);
                        rs=ptmt.executeQuery();
                        while (rs.next()){
                            sum+=rs.getFloat("ceiling");
                        }
                        System.out.println("所有信用账户透支额度总数:"+sum);
                        init();
                        break;
                    default:
                        System.err.println("输入错误");
                        init();
                        break;
                }
                break;
            case 4:
                System.exit(0);
                break;
            default :
                System.out.println("输入有误！");
                init();
        }

    }

    //用户注册
    public static void zhuce() throws SQLException{
        System.out.println("请输入你的姓名：");
        String username=input.next();
        System.out.println("请输入你的登录密码：");
        String p1=input.next();
        System.out.println("请再次输入你的确认密码：");
        String p2=input.next();
        System.out.println("请输入你的身份证号：");
        String personid=input.next();
        System.out.println("请输入你的邮箱：");
        String email=input.next();
        System.out.println("请选择账户类型：1.借记卡   2.信用卡");
        int usertype = input.nextInt();

        switch (usertype){
            case 1:
                ceiling=0;
                break;
            case 2:
                System.out.println("请输入信用额度");
                ceiling =input.nextFloat();
                break;
        }

        if(p1.equals(p2)){
            //两次输入的密码相同才可以注册
            String sql="insert into users (username,password,personid,email,balance,ceiling,usertype) values(?,?,?,?,0,?,?)";
            PreparedStatement ptmt=con.prepareStatement(sql);
            ptmt.setString(1, username);
            ptmt.setString(2, p1);
            ptmt.setString(3, personid);
            ptmt.setString(4, email);

            ptmt.setFloat(5, ceiling);
            ptmt.setInt(6, usertype);

            ptmt.execute();
            System.out.println("注册成功！");
            init();
        }else{
            System.out.println("你输入的密码与确认密码不相符，请重新注册：");
            zhuce();
        }
    }

    //用户登录
    public static void denglu() throws SQLException {
        System.out.println("请输入你的ID：");
        id=input.nextInt();
        System.out.println("请输入你的密码：");
        String password=input.next();

        String sql="select username,password from users where id=? and password=?";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.setString(2, password);
        ResultSet rs=ptmt.executeQuery();
        //从登录用户给出的账号密码来检测查询在数据库表中是否存在相同的账号密码
        if(rs.next()){
            System.out.println("登录成功！");
            showInfo();
        }else{
            System.out.println("信息有误！");
            denglu();
        }
    }

    //登录之后
    public static void afterLogin() throws SQLException {
        System.out.print("1.存款   2.取款  3.查询余额    4.转账    5.修改信用额度    6.退出系统");
        int ch=input.nextInt();
        String sql;
        ResultSet rs;
        PreparedStatement ptmt;
        switch (ch){
            case 1:
                deposit();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                sql="SELECT balance FROM users WHERE id=?";
                ptmt=con.prepareStatement(sql);
                ptmt.setInt(1, id);
                rs=ptmt.executeQuery();
                if(rs.next())
                    System.out.println("余额:"+rs.getFloat("balance"));
                    afterLogin();       //转入登录后菜单
                break;
            case 4:
                System.out.print("输入对方ID:");
                int id2=input.nextInt();
                sql="SELECT * FROM users WHERE id=?";
                ptmt=con.prepareStatement(sql);
                ptmt.setInt(1, id2);    //找对方id
                rs=ptmt.executeQuery();
                if(rs.next()){
                    if(usertype==1){
                        System.out.println("本卡余额:"+balance);

                        System.out.println("输入转账金额");
                        float money = input.nextFloat();

                        if(money>balance) {
                            System.out.println("余额不足！");
                            afterLogin();
                        }
                        else{
                            String sql3="update users set balance=? where id=?";    //自己余额-转账金额
                            PreparedStatement preStmt3 =con.prepareStatement(sql3);
                            preStmt3.setFloat(1, balance-money);
                            preStmt3.setInt(2, id);
                            preStmt3.executeUpdate();

                            String sql4="update users set balance=? where id=?";    //对方余额+转账金额
                            PreparedStatement preStmt4 =con.prepareStatement(sql4);
                            preStmt4.setFloat(1, rs.getFloat("balance")+money);
                            preStmt4.setInt(2, id2);
                            preStmt4.executeUpdate();
                            System.out.println("转账成功！");
                            afterLogin();       //转入登录后菜单
                        }
                    }
                    System.out.println("输入转账金额");
                    float money = input.nextFloat();
                    if(balance-money<ceiling){
                        System.err.println("额度不足");
                    }

                }else{
                    System.out.println("对方ID不存在！");
                    afterLogin();
                }
                break;
            case 5:
                if(usertype==2){
                    System.out.print("输入信用额度:");
                    float ceil = input.nextFloat();

                    if(ceil<-balance){
                        System.out.println("额度太低，无法设置！");
                        afterLogin();
                    }

                    String sql2="update users set ceiling=? where id=?";
                    PreparedStatement preStmt =con.prepareStatement(sql2);
                    preStmt.setFloat(1,ceil);
                    preStmt.setInt(2,id);
                    preStmt.executeUpdate();
                    showInfo();     //显示信息
                }
                System.err.println("不是信用卡，无法修改！");
                afterLogin();
                break;
            default:
                System.out.print("输入有误！");
                afterLogin();
                break;
        }
    }

    //存款
    public static void deposit() throws SQLException {
        System.out.print("输入存款金额(100的整数倍数)：");
        float money = input.nextFloat();
        if(money>0&&money%100==0)
            money+=balance;
        else {
            System.err.println("金额错误！");
            afterLogin();
        }

        String sql="update users set balance=? where id=?";     //更新余额
        PreparedStatement preStmt =con.prepareStatement(sql);
        preStmt.setFloat(1,money);
        preStmt.setInt(2,id);
        preStmt.executeUpdate();
        showInfo();     //显示信息
    }

    //取款
    public static void withdraw() throws SQLException{
        System.out.print("输入取款金额(100的整数倍数)：");
        float money = input.nextFloat();
        if(money>0&&money%100==0){
            if(usertype==1){    //借记卡
                if(money>balance){
                    System.err.println("余额不足！");
                    afterLogin();
                }else {
                    if(money>0&&money%100==0){
                        balance-=money;
                        String sql="update users set balance=? where id=?";
                        PreparedStatement preStmt =con.prepareStatement(sql);
                        preStmt.setFloat(1,balance);
                        preStmt.setInt(2,id);
                        preStmt.executeUpdate();
                        System.out.println("取款成功");
                        showInfo();
                    }else {
                        System.err.println("金额错误");
                        init();
                    }
                }
            }else{      //信用卡
            	//
                if(balance-money<-ceiling){
                    System.err.println("额度不足");
                    afterLogin();
                }else{

                        balance -= money;
                        String sql = "update users set balance=? where id=?";
                        PreparedStatement preStmt = con.prepareStatement(sql);
                        preStmt.setFloat(1, balance);
                        preStmt.setInt(2, id);
                        preStmt.executeUpdate();
                        System.out.println("取款成功");
                        showInfo();
                    }
            }
        }else{
            System.err.println("金额错误！\n");
            afterLogin();
        }

    }

    public static void showInfo() throws SQLException {
        String sql="select * from users where id=?";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs=ptmt.executeQuery();
        //从登录用户给出的账号密码来检测查询在数据库表中是否存在相同的账号密码
        if(rs.next()) {
            String type;
            if (rs.getInt("usertype") == 1)
                type = "借记卡";
            else
                type = "信用卡";
            System.out.println(
                    "ID:" + rs.getInt("id") +
                            "\n姓名:" + rs.getString("username") +
                            "\n身份证号:" + rs.getString("personid") +
                            "\n邮箱:" + rs.getString("email") +
                            "\n余额:" + rs.getFloat("balance") +
                            "\n透支额度:" + rs.getFloat("ceiling") +
                            "\n账户类型:" + type);

            id=rs.getInt("id");
            username=rs.getString("username");
            personId=rs.getString("personid");
            email=rs.getString("email");
            balance=rs.getFloat("balance");
            ceiling=rs.getFloat("ceiling");
            usertype=rs.getInt("usertype");
            afterLogin();
        }
    }
}
