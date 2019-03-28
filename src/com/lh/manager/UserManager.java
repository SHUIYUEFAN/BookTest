package com.lh.manager;

import java.util.HashSet;

import java.util.Set;

import com.lh.bean.User;
import com.lh.utils.InputUtils;
import com.lh.utils.MenuUtils;


public class UserManager {

    private Set<User> users = new HashSet<>();

    public UserManager() {

        users.add(new User("admin", "root"));
    }

    /**
     * 开始菜单
     * @author 水越帆
     * @date 2018年11月20日 下午2:19:35
     */

    public void start() {
        while (true) {

            MenuUtils.welcome();
            int choose = InputUtils.getInt(("请输入您的选择："));
            switch (choose) {
            case 1:
                User lUser = login();
                if (lUser != null) {
                    BookManager.getInstance().start(lUser);
                } else {
                    System.out.println("登录失败");
                }
                break;

            case 2:
                boolean reg = register();
                System.out.println(reg ? "注册成功" : "注册失败");
                break;

            case 3:
                System.out.println("退出程序");
                System.exit(0);
                break;

            default:
                break;
            }
        }

    }

    /***
     * 登录
     * 
     * @author 水越帆
     * @date 2018年11月20日 下午12:08:47
     */

    private User login() {

        while (true) {
            String username = InputUtils.getStr(("请输入用户名：(exit退出)"));
            if (username.equals("exit")) {
                start();
            }
            
            boolean checkUserName = checkUserName(username);
            
            if (!checkUserName) {
                System.out.println("用户名不存在,请重新输入:");
                continue;
            }
            
            String password = InputUtils.getStr(("请输入您的密码："));
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                    // 返回用户
                    return user;
                }

            }

        }

    }
    /***
     * 注册**
     * 
     * @author 水越帆
     * @date 2018年11月20日 下午12:09:04
     */

    private boolean register() {
        while (true) {
            String username = InputUtils.getStr("请输入你的用户名:(exit退出)");
            if (username.equals("exit")) {
                return false;
            }

            boolean isCheck = checkUserName(username);
            if (isCheck) {
                System.out.println("用户存在,请重新输入:");
                continue;
            }

            String password = InputUtils.getStr("请输入你的密码:");

            // 添加到 用户管理的集合中
            return users.add(new User(username, password));
        }
    }

    /***
     * 验证用户是否存在**
     * 
     * @author 水越帆
     * @date 2018年11月20日 下午12:05:01
     */

    private boolean checkUserName(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }

        return false;

    }
}
