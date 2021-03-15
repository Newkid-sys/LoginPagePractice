package com.company;

import java.util.HashMap;

public class IDAndPassword {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDAndPassword(){
        loginInfo.put("Ahmed", "BigSpicy25");
        loginInfo.put("Asad", "Gamerboy67");
        loginInfo.put("Mom", "AsadMayan2");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
