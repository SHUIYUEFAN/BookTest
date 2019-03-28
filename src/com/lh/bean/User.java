package com.lh.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lh.utils.InputUtils;
/**
 * 用户类
 * @author 水越帆
 * @date 2018年11月20日 下午2:49:45
 */
public class User {

    private String username;
    private String password;

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {
            this.username = username;
            this.password = password;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((password == null) ? 0 : password.hashCode());
            result = prime * result + ((username == null) ? 0 : username.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            User other = (User) obj;
            if (password == null) {
                    if (other.password != null)
                            return false;
            } else if (!password.equals(other.password))
                    return false;
            if (username == null) {
                    if (other.username != null)
                            return false;
            } else if (!username.equals(other.username))
                    return false;
            return true;
    }

    // 存书的书包

    private HashMap<Book, Integer> hashMap = new HashMap<>();


    /**
     * 保存书籍
     * @author 水越帆
     * @date 2018年11月20日 下午3:49:21
     */
    public void saveBook(HashMap<Book, Integer> map) {

            Set<Entry<Book, Integer>> entrySet = map.entrySet();

            for (Entry<Book, Integer> entry : entrySet) {
                   
                    Book book = entry.getKey();
                    Integer count = entry.getValue();
 
                    Integer num = hashMap.get(book);

                    // 装到 用户的书包中
                    hashMap.put(book, num == null ? count : num + count);

            }

            System.out.println("借书 成功");

    }

    /**
     * 还书
     * @author 水越帆
     * @date 2018年11月20日 下午3:46:43
     */
    public Map<Book, Integer> returnBook() {

            while (true) {

                    String bname = InputUtils.getStr("请输入书籍的名称:");
                    Book book = new Book(bname);

                    boolean containsKey = hashMap.containsKey(book);

                    if (!containsKey) {
                            System.out.println("没有这个本书,请重新输入");
                            continue;
                    }

                    int num = InputUtils.getInt("请输入还书的数量:");

                    // 书包中书的数量
                    Integer count = hashMap.get(book);

                    if (num > count) {
                            System.out.println("书包中没有这么多书");
                            return null;
                    }

                    
                    hashMap.put(book, count - num);

                    Map<Book, Integer> map = new HashMap<>();
                    map.put(book, num);
                    return map;
            }
    }

    /**
     * 显示借阅的书籍
     * @author 水越帆
     * @date 2018年11月20日 下午3:47:18
     */
    public void showBook() {

            Set<Entry<Book, Integer>> entrySet = hashMap.entrySet();

            System.out.println("图书\t数量");
            for (Entry<Book, Integer> entry : entrySet) {

                    System.out.println(entry.getKey().getBookName() + "\t" + entry.getValue());
            }

    }
}