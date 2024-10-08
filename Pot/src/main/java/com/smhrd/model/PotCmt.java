package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PotCmt {

    // 댓글 식별자 
    private int cmt_idx;

    // 원글 식별자 
    private int sns_idx;

    // 댓글 작성자 
    private String user_id;

    // 댓글 작성일자 
    private String created_at;

    // 댓글 내용 
    private String cmt_content;

    // 댓글 상태 
    private int cmt_likes;
    
    private String user_nick;

	public PotCmt(int sns_idx, String user_id, String cmt_content) {
		super();
		this.sns_idx = sns_idx;
		this.user_id = user_id;
		this.cmt_content = cmt_content;
	}


    
    
}
