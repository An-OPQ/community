package edu.hniu.community.vo;

import java.util.Arrays;

/**
 * @author jerry
 */
public class AuthoritySearchVo {
    private int pageNo;
    private int [] array;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "AuthoritySearchVo{" +
                "pageNo=" + pageNo +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
