package com.example.socketdemo.service;

public interface PyService {
    boolean start(int index);//开启哪一根天线
    String read();//开始读取标签
    boolean stop();//停止
    boolean write(String code);//写卡
}
