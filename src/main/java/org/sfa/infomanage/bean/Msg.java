package org.sfa.infomanage.bean;

import java.util.HashMap;

public class Msg {
    private HashMap<String,Object> data;

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public Msg(HashMap<String, Object> data) {
        this.data = data;
    }

    public Msg() {
    }
}
