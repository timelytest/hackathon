package com.example.cainiaoxiaozu.util.http.command;

public abstract class BaseCommand {

    protected Object[] objects;

    /**
     * 子类需要写自己的构造函数
     * @param objects 所有需要放进来的相关类
     */
    protected BaseCommand(Object... objects){
        this.objects = objects;
    }

    /**
     * 成功从网络得到返回值时侯的处理
     * @param body 返回值的字符串形式，可能需要转成class
     */
    public abstract void success(String body);

    /**
     * 返回值获取失败时
     * @param t 异常
     */
    public abstract void failure(Throwable t);
}
