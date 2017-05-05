package xueweu.atguigu.appnews.bean;

import java.util.List;

/**
 * 作者：田学伟 on 2017/5/1 19:14
 * QQ：93226539
 * 作用：
 */

public class MovieInfo {

    private List<TrailersBean> trailers;

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public static class TrailersBean {
        /**
         * id : 65406
         * movieName : 《亚瑟王》中国版预告片
         * coverImg : http://img5.mtime.cn/mg/2017/02/21/111556.45279918.jpg
         * movieId : 216639
         * url : http://vfx.mtime.cn/Video/2017/04/24/mp4/170424094054466834.mp4
         * hightUrl : http://vfx.mtime.cn/Video/2017/04/24/mp4/170424094054466834.mp4
         * videoTitle : 亚瑟王：斗兽争霸 中国版预告
         * videoLength : 96
         * rating : -1
         * type : ["动作","冒险","剧情","奇幻"]
         * summary : 欧洲远古神兽与人类展开大战
         */

        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private double rating;
        private String summary;
        private List<String> type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}

