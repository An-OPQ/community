/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类
 *
 * @author Blade
 * @since 2022-07-25
 */
@Data
@TableName("tb_question")
@EqualsAndHashCode(callSuper = true)
public class Question extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 文章的标题
	 */
	@ApiModelProperty(value = "文章标题")
	private String title;
	/**
	 * 文章的详情
	 */
	@ApiModelProperty(value = "文章详情")
	private String description;
	/**
	 * 文章类型ID
	 */
	@ApiModelProperty(value = "文章类型ID")
	private Integer typeId;
	/**
	 * 评论数据量
	 */
	@ApiModelProperty(value = "评论数据量")
	private Integer commentCount;
	/**
	 * 阅读数量
	 */
	@ApiModelProperty(value = "阅读数量")
	private Integer viewCount;
	/**
	 * 点赞数量
	 */
	@ApiModelProperty(value = "点赞数量")
	private Integer likeCount;


}
