package com.proj.detailpage;

public class bookComment extends Wishbooklist{
	 // ´ñ±Û ¹øÈ£ 
    private Integer commentnum;

    // ´ñ±Û 
    private String review;
    
    private Number rating;

    private Number commentLike;
    
    public Number getCommentLike() {
		return commentLike;
	}

	public void setCommentLike(Number commentLike) {
		this.commentLike = commentLike;
	}

	public Number getRating() {
		return rating;
	}

	public void setRating(Number rating) {
		this.rating = rating;
	}

	public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
