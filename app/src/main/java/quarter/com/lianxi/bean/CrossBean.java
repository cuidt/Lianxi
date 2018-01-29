package quarter.com.lianxi.bean;

import java.util.List;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */
//段子bean
public class CrossBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"吴希瑞！！八维最帅经理！！！！！没有之一！！！！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:52:28","imgUrls":null,"jid":1037,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"吴希瑞！！！！最帅啦！！！八维最帅经理！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:51:58","imgUrls":null,"jid":1036,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"吴希瑞！！！！最帅啦！！！八维最帅经理！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:51:41","imgUrls":null,"jid":1035,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"卡死机的逻辑啊山莨菪碱来看撒娇了的控件撒拉科技的看了撒娇埃里克加两块的记录卡计算可乐的境况的","createTime":"2018-01-18T20:31:41","imgUrls":null,"jid":1034,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"123123123","createTime":"2018-01-18T19:36:15","imgUrls":null,"jid":1033,"praiseNum":null,"shareNum":null,"uid":10869,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"123","praiseNum":"null"}},{"commentNum":null,"content":"快来撒多军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军或付军啥付案例卡酸辣粉来开始拉黑谁离开拉屎饿哦回复后俄日为何会烦恼善男信女绿能你你了困难方克立谁对你拿饭卡辽宁大厦看来你看电视你看了迪士尼离开","createTime":"2018-01-18T19:33:39","imgUrls":null,"jid":1032,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"你是不是傻","createTime":"2018-01-18T19:32:06","imgUrls":null,"jid":1031,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"你好","createTime":"2018-01-18T19:30:17","imgUrls":null,"jid":1030,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"哈哈哈哈哈哈哈奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥多历史课啊可接受的可垃圾奥斯卡了就离开静安寺离开家离开家埃里克森极乐空间看了撒娇拉开距离看见来看数据库结课啦机啊垃圾了","createTime":"2018-01-18T19:23:00","imgUrls":null,"jid":1029,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"梁冬侃接啊看似简单看就看案例记录的卡里克京东","createTime":"2018-01-18T19:19:51","imgUrls":null,"jid":1028,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 吴希瑞！！八维最帅经理！！！！！没有之一！！！！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！
         * createTime : 2018-01-18T20:52:28
         * imgUrls : null
         * jid : 1037
         * praiseNum : null
         * shareNum : null
         * uid : 3625
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : 张心卓大美女哈哈哈哈
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private Object icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
