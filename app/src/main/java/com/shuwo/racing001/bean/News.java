package com.shuwo.racing001.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asus01 on 2017/11/14.
 */

public class News implements Parcelable{


    /**
     * title : 皇马大将退步触目惊心！打热刺单场狂丢球29次
     * url : http://sports.sina.com.cn/g/laliga/2017-11-03/doc-ifynmzrs6387292.shtml
     * body : 44CA44CACgrmr6vml6DnlpHpl67vvIznmofpqazlia/pmJ/plb/pqazloZ7mtJvmsqHmnInlpITlnKjmnIDkvbPnirbmgIHvvIznlJroh7PlpITlnKjkuobkvY7mva7mnJ/jgIIK44CA44CA6Ieq5LuO5a+56Zi155qH5a626LSd6JKC5pav5Y+X5Lyk5LmL5ZCO77yM6ams5aGe5rSb5aeL57uI5rKh5pyJ5om+5Yiw5pyA5L2z55qE5q+U6LWb54q25oCB44CC5LiO54Ot5Yi655qE5q+U6LWb77yM6ams5aGe5rSb55qE6KGo546w5aCq56ew5Zmp5qKm77yM5LiO54Ot5Yi66L655ZCO5Y2r54m56YeM55qu5bCU55qE6L6D6YeP5Lit77yM5LuW5YWo6Z2i5aSE5LqO5LiL6aOO77yM5aSa5qyh6KKr5a+55omL5oqT5L2P5byx54K55omT54iG44CCCuaVsOaNruS4jeS9swrjgIDjgIDmlbDmja7mmL7npLrvvIwxLTPkuI3mlYzng63liLrnmoTmr5TotZvkuK3vvIzpqazloZ7mtJvljZXlnLrkuKLnkIMyOeasoe+8jOWIm+mAoOS6huS7ljkz5Zy65qyn5Yag5q+U6LWb55qE5paw57qq5b2V77yM6L+Z5piv5LuW5qyn5Yag5q+U6LWb6YeM56ys5LiA5qyh5Lii55CD5aaC5q2k5LmL5aSa44CC5YW25Lit6ams5aGe5rSb5Lyg55CDODjmrKHvvIzkvKDnkIPmiJDlip/njofku4XkuLo3OS41JeOAguWcqOeah+mprOmYteS4re+8jOWPquacieacrOazvemprOeahOS8oOeQg+aIkOWKn+eOh+avlOS7luS9juOAguWPpuWklu+8jOmprOWhnua0m+WcqOmYsuWuiOaWuemdouWNgeWIhuaDqOa3oe+8jOayoeacieWBmuWHuuS7u+S9leaKouaWre+8jOWPquaciTLmrKHmi6bmiKrjgIIK44CA44CA44CK6Zi/5pav5oql44CL6KGo56S677yM6b2Q6L6+5YaF5oCA5b+15LiK6LWb5a2j55qE5Y2h55Om5ZOI5bCU5LiO6ams5aGe5rSb44CC5LiK6LWb5a2j77yM5Lik5aSn6L655ZCO5Y2r5piv55qH6ams5oiQ5Yqf55qE5YWz6ZSu77yM5YW25Lit6ams5aGe5rSb5omT6L+bM+eQg+WKqeaUuzE05qyh77yM5Y2h55Om5ZOI5bCU5omT6L+bMeeQg+WKqeaUuzE15qyh44CC5L2G5piv5pys6LWb5a2j77yM6ams5aGe5rSb5ZyoMTAzOOWIhumSn+aJk+i/mzHnkIPliqnmlLsy5qyh77yM5Y2h55Om5ZOI5bCU5ZyoOTkw5YiG6ZKf6YeM5Yqp5pS7MuasoeOAggrjgIDjgIDvvIjljZfljZfvvIk=
     * picture : http://n.sinaimg.cn/sports/transform/20171103/g30A-fynmzrs6386926.jpg
     * time : 2017-11-03 10:52:53
     * page : 1
     */

    private String title;
    private String url;
    private String body;
    private String picture;
    private String time;
    private int page;

    protected News(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
