/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.business1.service;

import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    public boolean Login(String name,String pwd)
    {
        boolean isTrue=false;
        if (name.equals("aa")&&pwd.equals("bb"))
            isTrue=true;
        return isTrue;
    }
}
