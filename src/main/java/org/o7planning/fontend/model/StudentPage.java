package org.o7planning.fontend.model;

import java.util.ArrayList;
import java.util.List;

public class StudentPage {
    private int page;
    private int totalPage;
    private List<Student> listResult = new ArrayList<>();

    public StudentPage(int page, int totalPage, List<Student> listResult) {
        super();
        this.page = page;
        this.totalPage = totalPage;
        this.listResult = listResult;
    }

    public StudentPage() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Student> getListResult() {
        return listResult;
    }

    public void setListResult(List<Student> listResult) {
        this.listResult = listResult;
    }

    @Override
    public String toString() {
        return "StudentPage{" +
                "page=" + page +
                ", totalPage=" + totalPage +
                ", listResult=" + listResult +
                '}';
    }
}
