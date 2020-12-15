package com.renard.rjnetworkdemo.Fragment.news.detail.bean;

import android.os.Parcelable;
import java.util.List;

/**
 * Created by Riven_rabbit on 12/8/20
 *
 * @author suyanan
 */
public class NewsDetailInfo {

    private String body;
    private int replyCount;
    private String shareLink;
    private String digest;
    private String dkeys;
    private String ec;
    private String docid;
    private boolean picnews;
    private String title;
    private String tid;
    private String template;
    private int threadVote;
    private int threadAgainst;
    private String replyBoard;
    private String source;
    private boolean hasNext;
    private String voicecomment;
    private String ptime;
    private List<?> users;
    private List<?> ydbaike;
    /**
     * ref : <!--SPINFO#0-->
     * spcontent : <p>　　<a href="http://3g.163.com/ntes/16/0825/12/BVAK755300963VRO.html">曝王宝强9套房产均不在其名下称必须要孩子</a></p><p>　　王宝强离婚案沉寂了快一周，最近又有媒体陆续查到他在美国的房产，位于山的那边海的那边的美利坚南加州地区，但是目前房产的处理尚未有任何眉目。</p><p>　　重案组37号打探到的消息是，<b>宝宝虽然坐拥9套房产，但均没有登记在他个人名下……此外，王宝强离婚案件或将不公开审理，而王宝强本人最在意的是要回孩子的抚养权。</b></p>
     * sptype : 回顾
     */

    private List<SpinfoEntity> spinfo;
    private List<?> link;
    private List<?> votes;
    /**
     * ref : <!--IMG#0-->
     * pixel : 577*501
     * alt :
     * src : http://cms-bucket.nosdn.127.net/62b047f116804ffc96de7eb7fb73b5b420160826061217.jpeg
     */

    private List<ImgEntity> img;
    /**
     * hasCover : false
     * subnum : 0
     * alias : yaowentuisong
     * tname : 要闻推送
     * ename : pushliebiao
     * tid : T1350294190231
     * cid : C1350294152567
     */

    private List<TopiclistNewsEntity> topiclist_news;
    private List<?> topiclist;
    private List<?> boboList;
    /**
     * topicId : SJ0693453310829241827
     * topicName : 说说宝强离婚
     */

    private List<HuatiEntity> huati;
    private List<?> apps;
    /**
     * id : BUTFDDM200031H2L
     * title : 王宝强疑似“小三”大起底 马蓉宋喆能洗白吗？
     * source : 网易娱乐
     * imgsrc : http://cms-bucket.nosdn.127.net/c463a63824a44934a70181803643ce4020160820101529.png
     * docID : BUTFDDM200031H2L
     * type : doc
     * ptime : 2016-08-20 10:03:43
     * href :
     */

    private List<NewsItemInfo> relative_sys;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDkeys() {
        return dkeys;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<?> getUsers() {
        return users;
    }

    public void setUsers(List<?> users) {
        this.users = users;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public List<SpinfoEntity> getSpinfo() {
        return spinfo;
    }

    public void setSpinfo(List<SpinfoEntity> spinfo) {
        this.spinfo = spinfo;
    }

    public List<?> getLink() {
        return link;
    }

    public void setLink(List<?> link) {
        this.link = link;
    }

    public List<?> getVotes() {
        return votes;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public List<ImgEntity> getImg() {
        return img;
    }

    public void setImg(List<ImgEntity> img) {
        this.img = img;
    }

    public List<TopiclistNewsEntity> getTopiclist_news() {
        return topiclist_news;
    }

    public void setTopiclist_news(List<TopiclistNewsEntity> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public List<?> getTopiclist() {
        return topiclist;
    }

    public void setTopiclist(List<?> topiclist) {
        this.topiclist = topiclist;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public List<HuatiEntity> getHuati() {
        return huati;
    }

    public void setHuati(List<HuatiEntity> huati) {
        this.huati = huati;
    }

    public List<?> getApps() {
        return apps;
    }

    public void setApps(List<?> apps) {
        this.apps = apps;
    }

    public List<NewsItemInfo> getRelative_sys() {
        return relative_sys;
    }

    public void setRelative_sys(List<NewsItemInfo> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public static class SpinfoEntity {
        private String ref;
        private String spcontent;
        private String sptype;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSpcontent() {
            return spcontent;
        }

        public void setSpcontent(String spcontent) {
            this.spcontent = spcontent;
        }

        public String getSptype() {
            return sptype;
        }

        public void setSptype(String sptype) {
            this.sptype = sptype;
        }
    }

    public static class ImgEntity {
        private String ref;
        private String pixel;
        private String alt;
        private String src;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }

    public static class TopiclistNewsEntity {
        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

    public static class HuatiEntity {
        private String topicId;
        private String topicName;

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }
}
