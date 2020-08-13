package com.proj.detailpage;

public class bookSearchInfo {
   private Integer masterseq;
   private String title;
   private String imgurl;
   private String totalRating;

   public String getTotalRating() {
      return totalRating;
   }

   public void setTotalRating(String totalRating) {
      this.totalRating = totalRating;
   }

   public Integer getMasterseq() {
      return masterseq;
   }

   public void setMasterseq(Integer masterseq) {
      this.masterseq = masterseq;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getImgurl() {
      return imgurl;
   }

   public void setImgurl(String imgurl) {
      this.imgurl = imgurl;
   }

}