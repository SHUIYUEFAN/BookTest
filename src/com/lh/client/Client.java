package com.lh.client;

import com.lh.manager.UserManager;

/**
 * 入口
 * @author 水越帆
 * @date 2018年11月20日 上午10:45:14
 */
public class Client {

    public static void main(String[] args) {
        
        new UserManager().start();
    }

}
