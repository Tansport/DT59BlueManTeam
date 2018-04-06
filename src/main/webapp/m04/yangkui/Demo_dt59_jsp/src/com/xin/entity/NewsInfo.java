


package com.xin.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:54:23 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class NewsInfo {
    private int newsId;
    private int typeId;
    private String newsTitle;
    private String newsAuthor;
    private String newsSummary;
    private String newsContent;
    private String newsPic;
    
    public int getNewsId() {
        return newsId;
    }
    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getNewsTitle() {
        return newsTitle;
    }
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    public String getNewsAuthor() {
        return newsAuthor;
    }
    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }
    public String getNewsSummary() {
        return newsSummary;
    }
    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }
    public String getNewsContent() {
        return newsContent;
    }
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
    public String getNewsPic() {
        return newsPic;
    }
    public void setNewsPic(String newsPic) {
        this.newsPic = newsPic;
    }
  
}

