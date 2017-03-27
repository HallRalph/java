package BAM;

import java.util.Scanner;

/**
 * * datou on 2017/3/24.
 */
public class Account {

    long id;
    String password;
    String name;
    String personId;
    String email;
    double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

class SavingAccount extends Account{
    public SavingAccount(long id,String password,String name,String personId,String email,double balance){
        this.id=id;
        this.password=password;
        this.name=name;
        this.personId=personId;
        this.email=email;
        this.balance=balance;
    }

}

class CreditAccount extends Account{
    double ceiling;
    public CreditAccount(long id,String password,String name,String personId,String email,double balance,double ceiling){
        this.id=id;
        this.password=password;
        this.name=name;
        this.personId=personId;
        this.email=email;
        this.balance=balance;
        this.ceiling=ceiling;
    }

    double getCeiling(){
        return ceiling;
    }


}

class Bank {
    SavingAccount[] savingAccounts = new SavingAccount[20];
    CreditAccount[] creditAccounts = new CreditAccount[20];

    //创建储蓄卡账户
    void csavingAccounts(String password, String name, String personId, String email, double balance) {
        savingAccounts[totalSaving()] = new SavingAccount(totalSaving(), password, name, personId, email, balance);
        //savingAccounts[0]=new SavingAccount(123,"123","datou","2414","11267",100.00);

    }

    //创建信用卡账户
    void cCreditAccounts(String password, String name, String personId, String email, double balance, double ceiling) {
        creditAccounts[totalCredit()] = new CreditAccount(totalCredit() + 50, password, name, personId, email, balance, ceiling);
    }

    //存款
    void deposit(int pid, double money, int j) {
        if (pid < 51)
            savingAccounts[pid].balance += money;
        else {
            pid -= 51;
            creditAccounts[pid].balance += money;
        }

        System.out.println("存款成功，存入" + money + "元");
        showInfo(pid);
        if (j == 1)
            afterLogin(pid);
        else
            afterLogin2(pid);
    }

    //取款
    void withdraw(int pid, double money, int j) {

        if (pid < 51) {
            if (money < savingAccounts[pid].balance) {
                savingAccounts[pid].balance -= money;
                System.out.println("取款成功，取出" + money + "元");
                showInfo(pid);
                if (j == 1)
                    afterLogin(pid);
                else
                    afterLogin2(pid);
            } else {
                System.out.println("余额不足");
                if (j == 1)
                    afterLogin(pid);
                else
                    afterLogin2(pid);
            }

        } else {
            if (money < creditAccounts[pid].balance) {
                creditAccounts[pid].balance -= money;
                System.out.println("取款成功，取出" + money + "元");
                showInfo(pid);
                if (j == 1)
                    afterLogin(pid);
                else
                    afterLogin2(pid);
            } else {
                System.out.println("余额不足");
                if (j == 1)
                    afterLogin(pid);
                else
                    afterLogin2(pid);
            }
        }
    }

    void setCeiling(int pid, double ceil) {
        creditAccounts[pid].ceiling = ceil;
        showInfo(pid + 51);
        afterLogin2(pid);
    }

    //储蓄卡用户数
    int totalSaving() {
        int i, s = 0;
        for (i = 0; i < savingAccounts.length; i++)
            if (savingAccounts[i] != null)
                s++;
        return s;
    }

    //信用卡用户数
    int totalCredit() {
        int i, s = 0;
        for (i = 0; i < creditAccounts.length; i++)
            if (creditAccounts[i] != null)
                s++;
        return s;
    }

    //显示用户信息
    void showInfo(int pid) {
        if (pid < 51) {
            System.out.println(savingAccounts[pid].getId() + "," + savingAccounts[pid].getName() + "," + savingAccounts[pid].getPassword() + "," + savingAccounts[pid].getPersonId() + "," + savingAccounts[pid].getEmail() + "," + savingAccounts[pid].getBalance());
        } else {
            pid -= 51;
            System.out.println(creditAccounts[pid].getId() + "," + creditAccounts[pid].getName() + "," + creditAccounts[pid].getPassword() + "," + creditAccounts[pid].getPersonId() + "," + creditAccounts[pid].getEmail() + "," + creditAccounts[pid].getBalance() + "," + creditAccounts[pid].getCeiling());
        }
    }

    //总余额
    double totalBalance() {
        double s = 0;
        for (int i = 0; i < totalSaving(); i++)
            s += savingAccounts[i].balance;
        for (int i = 0; i < totalCredit(); i++)
            s += creditAccounts[i].balance;
        return s;
    }

    //总透支
    double totalCeiling() {
        double s = 0;
        for (int i = 0; i < totalCredit(); i++)
            s += creditAccounts[i].ceiling;
        return s;
    }

    void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入身份证号：");
        String str = in.next();
        int i;
        for (i = 0; i < totalSaving(); i++) {
            if (savingAccounts[i].personId.equals(str)) {
                System.out.println("请输入密码：");
                String pwd = in.next();
                if (savingAccounts[i].password.equals(pwd))
                    System.out.print("登录成功    ");
                    afterLogin(i);
            }
        }
        for (i = 0; i < totalCredit(); i++) {
            if (creditAccounts[i].personId.equals(str)) {
                System.out.println("请输入密码：");
                String pwd = in.next();
                if (creditAccounts[i].password.equals(pwd))
                    System.out.print("登录成功    ");
                    afterLogin2(i);
            }
        }
        System.out.println("输入错误");
        showMenu();
    }
Scanner in = new Scanner(System.in);

    void afterLogin(int i) {
        int j = 1;
        System.out.print("1.存款   2.取款  3.退出系统");
        int d = in.nextInt();
        switch (d) {
            case 1:     // 存款
                System.out.println("输入存款金额");
                double money = in.nextDouble();
                deposit(i, money, j);
                break;
            case 2:     // 取款
                System.out.println("输入取款金额");
                double money2 = in.nextDouble();
                withdraw(i, money2, j);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("输入错误");
                afterLogin(i);
        }
    }

    void afterLogin2(int i){
        int j=2;
        System.out.println("请输入密码：");
        String pwd = in.next();
        if(creditAccounts[i].password.equals(pwd)) {
            System.out.println("登录成功:1.存款   2.取款  3.设置透支额度  4.退出系统");
            int d = in.nextInt();
            switch (d) {
                case 1:     // 存款
                    System.out.println("输入存款金额");
                    double money = in.nextDouble();
                    deposit(i, money,j);
                    break;
                case 2:     // 取款
                    System.out.println("输入存款金额");
                    double money2 = in.nextDouble();
                    withdraw(i, money2,j);
                    break;
                case 3:     //
                    System.out.println("输入透支额度");
                    double ceil = in.nextDouble();
                    setCeiling(i,ceil);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("输入错误");
                    afterLogin2(i);
            }
        }
    }

    void showMenu()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("选择用户类型：1.普通用户   2.管理员   3.退出系统");
        int ch = in.nextInt();
        switch (ch)
        {
            case 1:     // 普通用户
                System.out.println("1.开户  2.登录");
                int ch2 = in.nextInt();
                switch (ch2)
                {
                    case 1:     // 开户
                        System.out.println("1.储蓄卡   2.信用卡   3.退出系统");
                        int c = in.nextInt();
                        switch (c)
                        {
                            case 1:     //储蓄卡
                                System.out.println("请输入姓名：");
                                String name = in.next();
                                String pwd="1",pwd2="2";
                                while (!pwd.equals(pwd2)){
                                    System.out.println("请输入密码：");
                                    pwd = in.next();
                                    System.out.println("请确认密码：");
                                    pwd2 = in.next();
                                }
                                System.out.println("请输入身份证号：");
                                String personId=in.next();

                                System.out.println("请输入email：");
                                String email=in.next();
                                csavingAccounts(pwd,name,personId,email,0);
                                showInfo(totalSaving()-1);
                                showMenu();
                                break;
                            case 2:     // 信用卡
                                System.out.println("请输入姓名：");
                                String aname = in.next();
                                String apwd="1",apwd2="2";
                                while (!apwd.equals(apwd2)){
                                    System.out.println("请输入密码：");
                                    apwd = in.next();
                                    System.out.println("请确认密码：");
                                    apwd2 = in.next();
                                }
                                System.out.println("请输入身份证号：");
                                String apersonId=in.next();

                                System.out.println("请输入email：");
                                String aemail=in.next();
                                System.out.println("请输入透支额度：");
                                double ceiling=in.nextDouble();
                                cCreditAccounts(apwd,aname,apersonId,aemail,0,ceiling);
                                showInfo(totalCredit()+50);
                                showMenu();
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                System.out.println("输入错误");
                                showMenu();
                        }
                        break;

                    case 2:     // 登录
                        login();
                        System.out.println("输入错误");
                        showMenu();
                        break;
                    default:
                        System.out.println("输入错误");
                        showMenu();
                }
                break;

            case 2:     // 管理员
                System.out.println("1.统计银行所有账户余额总数  2.统计所有信用账户透支额度总数    3.退出系统");
                int z = in.nextInt();
                switch (z){
                    case 1:
                        System.out.println(totalBalance());
                        showMenu();
                        break;
                    case 2:
                        System.out.println(totalCeiling());
                        showMenu();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("输入错误");
                        showMenu();
                        break;
                }
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("输入错误");
                showMenu();
                break;
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.showMenu();
    }
}