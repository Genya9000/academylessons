package org.academy.api.pojo.nameEvgeny;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CommentPojo{

	@SerializedName("body")
	private String body;
}