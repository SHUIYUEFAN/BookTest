package com.lh.bean;

/**
 * 书籍类
 * @author 水越帆
 * @date 2018年11月20日 下午2:49:20
 */
public class Book {

    private String bookName;

    public Book(String bookName) {
        super();
        this.bookName = bookName;
    }

    public Book() {
        super();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (bookName == null) {
            if (other.bookName != null)
                return false;
        } else if (!bookName.equals(other.bookName))
            return false;
        return true;
    }

}
