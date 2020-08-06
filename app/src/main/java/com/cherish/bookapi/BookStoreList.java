package com.cherish.bookapi;

public class BookStoreList {
    private  String title;
    private  String subtitle;
    private  String isbn13;
    private String price;
    private String imageUrl;

//
//    public  BookStoreList( String bookTitle, String bookSubTitle, String bookUrL, double bookPrice,int bookNumber){
//
//        title = bookTitle;
//        subtitle = bookSubTitle;
//        isbn13 = bookNumber;
//        price = bookPrice;
//        imageUrl = bookUrL;
//
//    }
//        public BookStoreList() {
//
//        }

    public BookStoreList(String bookTitle, String bookSubTitle, String bookPrice,String bookNumber) {

        title = bookTitle;
        subtitle = bookSubTitle;
        isbn13 = bookNumber;
        price = bookPrice;
//        imageUrl = bookUrL;

    }
//
    public BookStoreList(){
        //do not initialize
    }



    public  void  setTitle(String bookTitle){
        title = bookTitle;
    }
    public String getTitle(){
        return title;
    }



    public void setSubTitle(String bookSubTitle){
        subtitle = bookSubTitle;
    }

    public  String getSubTitle(){
        return subtitle;
    }



    public void setIsbn(String bookNumber){
        isbn13 = bookNumber;
    }
    public String getIsbn(){
        return isbn13;
    }



    public void setPrice(String bookPrice){
        price = bookPrice;
    }
    public String getPrice(){
        return price;
    }



//
//    public void setImageUrl(String bookUrl){
//        imageUrl=bookUrl;
//    }
//
//    public String getImageUrl(){
//        return imageUrl;
//    }



}
