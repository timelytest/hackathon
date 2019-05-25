package com.example.cainiaoxiaozu.util.http.command;

public abstract class BaseCommand {

    protected Object[] objects;

    protected BaseCommand(Object... objects){
        this.objects = objects;
    }

    public abstract void success(String body);

    public abstract void failure(Throwable t);
}
