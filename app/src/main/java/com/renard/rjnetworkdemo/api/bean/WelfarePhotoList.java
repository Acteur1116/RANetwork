package com.renard.rjnetworkdemo.api.bean;

import java.util.List;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
public class WelfarePhotoList {
    /**
     * data : [{"_id":"5e5148e76e7524f833c3f7a0","author":"鸢媛","category":"Girl","createdAt":"2020-02-25 08:00:00","desc":"愿此时平淡，若彼时灿烂。","images":["http://gank.io/images/2e75774eac3f497caca35b3de7c50a42"],"likeCounts":3,"publishedAt":"2020-02-25 08:00:00","stars":1,"title":"第6期","type":"Girl","url":"http://gank.io/images/2e75774eac3f497caca35b3de7c50a42","views":1000},{"_id":"5e512d8107d934eade79461c","author":"鸢媛","category":"Girl","createdAt":"2020-02-24 08:00:00","desc":"心有多远，你就能走多远，做一个温暖的人，浅浅笑，轻轻爱，稳稳走。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/ce66aa74d78f49919085b2b2808ecc50"],"likeCounts":1,"publishedAt":"2020-02-24 08:00:00","stars":1,"title":"第5期","type":"Girl","url":"http://gank.io/images/ce66aa74d78f49919085b2b2808ecc50","views":1125},{"_id":"5e50f1d4ccad97da1aa9f6d7","author":"鸢媛","category":"Girl","createdAt":"2020-02-23 08:00:00","desc":"执子之手，共你一世风霜。\n吻子之眸，赠你一世深情。","images":["http://gank.io/images/28ff615f01f5400f97a7ce6c085ddf11"],"likeCounts":0,"publishedAt":"2020-02-23 08:00:00","stars":1,"title":"第4期","type":"Girl","url":"http://gank.io/images/28ff615f01f5400f97a7ce6c085ddf11","views":915},{"_id":"5e50f1a1ccad97da1aa9f6d5","author":"鸢媛","category":"Girl","createdAt":"2020-02-22 08:00:00","desc":"看着月亮时，能想到的人只有你，这就是我的小小心意。 \u200b\u200b\u200b\u200b","images":["http://gank.io/images/aa3be1436248473996790a89f6583e04"],"likeCounts":1,"publishedAt":"2020-02-22 08:00:00","stars":1,"title":"第3期","type":"Girl","url":"http://gank.io/images/aa3be1436248473996790a89f6583e04","views":917},{"_id":"5e50f16eccad97da1aa9f6d3","author":"鸢媛","category":"Girl","createdAt":"2020-02-21 08:00:00","desc":"我去得了任何地方，却永远到不了你心里，就像你一直在我心里，却永远看不到我的悲伤。","images":["http://gank.io/images/2b713742032c4b38a604389a22285a53"],"likeCounts":0,"publishedAt":"2020-02-21 08:00:00","stars":5,"title":"第2期","type":"Girl","url":"http://gank.io/images/2b713742032c4b38a604389a22285a53","views":1257},{"_id":"5e4e092004a2d596d4b67d0c","author":"鸢媛","category":"Girl","createdAt":"2020-02-20 08:00:00","desc":"念念不忘，必有回响。","images":["http://gank.io/images/31f92f7845f34f05bc10779a468c3c13"],"likeCounts":0,"publishedAt":"2020-02-20 08:00:00","stars":6,"title":"第1期","type":"Girl","url":"http://gank.io/images/31f92f7845f34f05bc10779a468c3c13","views":2618}]
     * page : 10
     * page_count : 10
     * status : 100
     * total_counts : 96
     */

    private Integer page;
    private Integer page_count;
    private Integer status;
    private Integer total_counts;
    private List<WelfarePhotoInfo> data;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage_count() {
        return page_count;
    }

    public void setPage_count(Integer page_count) {
        this.page_count = page_count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotal_counts() {
        return total_counts;
    }

    public void setTotal_counts(Integer total_counts) {
        this.total_counts = total_counts;
    }

    public List<WelfarePhotoInfo> getData() {
        return data;
    }

    public void setData(List<WelfarePhotoInfo> data) {
        this.data = data;
    }
}
