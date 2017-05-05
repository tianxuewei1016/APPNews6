package xueweu.atguigu.appnews.bean;

import java.util.List;

/**
 * 作者：田学伟 on 2017/5/1 00:00
 * QQ：93226539
 * 作用：
 */

public class NewsInfo {


    /**
     * size : 10
     * list : [{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/8/80/807933cb7f930a1fd1e37882f260773f.jpg","has_content":true,"docurl":"http://war.163.com/17/0430/11/CJ94DB4T000181KT.html","id":11513,"time":"2017-04-30 11:56:16","title":"港媒: 蔡英文遭特朗普＂打脸＂  台已被边缘化","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/855fbebb32544685920dd6403b6066d220170430111114.png","has_content":true,"docurl":"http://war.163.com/17/0430/11/CJ91RSCD000181KT.html","id":11502,"time":"2017-04-30 11:11:47","title":"美国卡尔文森号航母与韩军联合演练 将持续到下周","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/e8c11a2d3b1546308d4e929f86da7aa520170430110641.png","has_content":true,"docurl":"http://war.163.com/17/0430/11/CJ91IVBJ000181KT.html","id":11496,"time":"2017-04-30 11:06:55","title":"日媒:美航母与日本海上自卫队实施联合训练","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/cc2d8e6f2fb54beb90486aeeb0d1e68820170430110144.png","has_content":true,"docurl":"http://war.163.com/17/0430/11/CJ91A2M6000181KT.html","id":11497,"time":"2017-04-30 11:02:03","title":"中国实现绝热量子质因数分解 或建量子计算机","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/2f8cbe369c144e488cc4307e16a1d5a420170430105939.png","has_content":true,"docurl":"http://war.163.com/17/0430/11/CJ916UOL000181KT.html","id":11498,"time":"2017-04-30 11:00:21","title":"拒绝付费！韩国国防部重申＂萨德＂经费由美军承担","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/245d1e9822f64911879a359da36ef1d520170430105912.png","has_content":true,"docurl":"http://war.163.com/17/0430/10/CJ914U20000181KT.html","id":11492,"time":"2017-04-30 10:59:15","title":"拒绝付费！韩国国防部重申萨德经费由美军承担","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/f6d274d1ce1d43c083a34d1923261b8820170430105651.png","has_content":true,"docurl":"http://war.163.com/17/0430/10/CJ911JRU000181KT.html","id":11495,"time":"2017-04-30 10:57:26","title":"\u201c蛟龙\u201d攀登南海中部海山 获珍贵玄武岩样品","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/7b8f043e7e374dd0aae2c6f610e8b64b20170430105242.png","has_content":true,"docurl":"http://war.163.com/17/0430/10/CJ90P152000181KT.html","id":11493,"time":"2017-04-30 10:52:45","title":"美威胁朝鲜将部署更多舰船 朝媒：或引爆核战争","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/a52340b86b554ff59476df30c92edf4520170430105000.png","has_content":true,"docurl":"http://war.163.com/17/0430/10/CJ90K3NI000181KT.html","id":11494,"time":"2017-04-30 10:50:04","title":"斯诺登机密文件公开：美日秘密联合监控60余年","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/04133de9a3174e7fb280d9570f6dbe9a20170430104738.png","has_content":true,"docurl":"http://war.163.com/17/0430/10/CJ90G5SR000181KT.html","id":11485,"time":"2017-04-30 10:47:55","title":"日媒：美国航母与日本海上自卫队实施联合训练","channelname":"war"}]
     */

    private int size;
    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * imgurl : http://cms-bucket.nosdn.127.net/catchpic/8/80/807933cb7f930a1fd1e37882f260773f.jpg
         * has_content : true
         * docurl : http://war.163.com/17/0430/11/CJ94DB4T000181KT.html
         * id : 11513
         * time : 2017-04-30 11:56:16
         * title : 港媒: 蔡英文遭特朗普＂打脸＂  台已被边缘化
         * channelname : war
         */

        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}
