package com.example.niu.yummy;

/**
 * Created by 路人 on 2017/6/13.
 */

public class PutPtr {
    private int PictureId;
    private String ptr_url;

    public PutPtr(int pictureId, String ptr_url) {
        PictureId = pictureId;
        this.ptr_url = ptr_url;
    }


    public String getPtr_url() {
        return ptr_url;
    }

    public void setPtr_url(String ptr_url) {
        this.ptr_url = ptr_url;
    }

    public int getPictureId() {
        return PictureId;
    }

    public void setPictureId(int pictureId) {
        PictureId = pictureId;
    }
}
