package com.rsp.hbm.adapters;

public class SliderItem {
    int image;
    String url,descriptions,title;

    public SliderItem(int image, String url, String descriptions, String title) {
        this.image = image;
        this.url = url;
        this.descriptions = descriptions;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
