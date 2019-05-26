package com.example.cainiaoxiaozu.ui.fragment.zone;

import java.util.UUID;

public class Crime {

    private UUID uuid;
    private String tittle;
    private String content;

    public Crime() {
    }

    public Crime(UUID uuid, String tittle, String content) {
        this.uuid = uuid;
        this.tittle = tittle;
        this.content = content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
