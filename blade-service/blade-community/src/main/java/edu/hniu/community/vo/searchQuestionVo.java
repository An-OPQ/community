package edu.hniu.community.vo;

/**
 * @author jerry
 */
public class searchQuestionVo {
    private String title;
    private int typeid;
    private String classify;
    private int sort;
    private int pageNo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "searchQuestionVo{" +
                "title='" + title + '\'' +
                ", typeid=" + typeid +
                ", classify='" + classify + '\'' +
                ", sort=" + sort +
                ", pageNo=" + pageNo +
                '}';
    }
}
